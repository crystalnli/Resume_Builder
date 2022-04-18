package com.example.resumebuilder
import android.app.Application
import android.content.Context
import java.io.File
import java.io.FileOutputStream

class DataProcess{

    companion object{
        fun getWorkingDirectory(): String {
            val directory = File("");
            return directory.absolutePath
        }

        fun writeToFile(str:String?){
            var file = File(getWorkingDirectory(),"savedData.txt")
            file.writeText(str?:"",Charsets.UTF_8)
        }



    }


    fun write(fName:String){
    }

    fun read(fName:String){
    }

}