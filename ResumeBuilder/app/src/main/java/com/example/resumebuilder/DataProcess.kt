package com.example.resumebuilder
import android.app.Application
import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class DataProcess{

    companion object{
        fun getWorkingDirectory(): String {
            val directory = File("");
            return directory.absolutePath
        }


        fun write(path: File?, fileName:String, data:String){
            val file = File(path,fileName)
            if(!file.exists()) file.createNewFile()
            FileOutputStream(file).use {
                it.write(data.toByteArray())
            }
            Log.d("write",data)
        }


        fun read(path: File?, fileName:String) : String{
            val file = File(path,fileName)
            var data = ""
            if(file.exists()){
                data = FileInputStream(file).bufferedReader().use { it.readText() }
                Log.d("checktag",data)
            }
            return data
        }

        fun readFileFromAssets(context:Context,fileName: String):String{
            return context.assets.open(fileName).use {
                it.bufferedReader().use{
                    it.readText()
                }
            }
        }


    }


}