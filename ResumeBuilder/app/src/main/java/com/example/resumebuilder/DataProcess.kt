package com.example.resumebuilder
import android.app.Application
import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class DataProcess{

    companion object {

        @RequiresApi(Build.VERSION_CODES.KITKAT)

        fun getWorkingDirectory(): String {
            val directory = File("");
            return directory.absolutePath
        }


        fun write(path: File?, fileName: String, data: String) {
            val file = File(path, fileName)
            if (!file.exists()) file.createNewFile()
            FileOutputStream(file).use {
                it.write(data.toByteArray())
            }
            Log.d("write", data)
        }

        fun writetoExternal(app: Application, data: String, fileName: String) {
            val file = File(app.getExternalFilesDir("resume"), fileName)
            if (!file.exists()) file.createNewFile()
            FileOutputStream(file).use {
                it.write(data.toByteArray())
            }
            Log.d("write", data)
        }

        fun read(path: File?, fileName: String): String {
            val file = File(path, fileName)
            var data = ""
            if (file.exists()) {
                data = FileInputStream(file).bufferedReader().use { it.readText() }
                Log.d("checktag", file.absolutePath)
            }
            return data
        }


        fun generatePDF(data:String, fileName: String) {
            val pdf = PdfDocument()
            val page = pdf.startPage(PdfDocument.PageInfo.Builder(
                100, 200, 1).create())
            val canvas = page.canvas
            val paint = Paint()
            try {
                canvas.drawText(data,10F,20F,paint)
                pdf.finishPage(page)

                val fileName = "testing.pdf"
                val file = File(getWorkingDirectory(),fileName)
                pdf.writeTo(file.outputStream())
                pdf.close()

                Log.d("eee","dddd")
            }
            catch (e: Exception) {
                Log.d("www","kkkk")  }
        }

        fun readFileFromAssets(context: Context, fileName: String): String {
            return context.assets.open(fileName).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }


        fun pdf(view: View,path: File?){
            // create a new document
            val document = PdfDocument();

            // create a page description
            val pageInfo = PdfDocument.PageInfo.Builder(100, 100, 1).create();

            // start a page
            val page = document.startPage(pageInfo);
            view.draw(page.getCanvas());
            document.finishPage(page);
            val fileName = "testing.pdf"
            val file = File(Environment.getExternalStorageDirectory(),fileName)
            document.writeTo(file.outputStream());
            // close the document
            document.close();

            Log.d("location",file.absolutePath)
        }



    }

}