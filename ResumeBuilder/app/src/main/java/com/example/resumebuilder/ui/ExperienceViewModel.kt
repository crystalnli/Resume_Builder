package com.example.resumebuilder.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.resumebuilder.DataProcess
import com.example.resumebuilder.models.Experience
import com.squareup.moshi.*

class ExperienceViewModel (app: Application) : AndroidViewModel(app){
    val fileName = "experience.json"
    val expData = MutableLiveData<List<Experience>>()
    private val listType = Types.newParameterizedType(
        List::class.java, Experience::class.java
    )
    init {
        val data = DataProcess.readFileFromAssets(app,fileName)
        parseText(data)
    }

    fun parseText(data:String){
        //var gson = Gson()
        //var skillList = gson.fromJson(data, Skill::class.java)

        val moshi = Moshi.Builder()
            .add(NULL_TO_EMPTY_STRING_ADAPTER)
            .build()
        val adapter: JsonAdapter<List<Experience>> = moshi.adapter(listType)
        val expList = adapter.fromJson(data)
        expData.value = adapter.fromJson(data)?:emptyList()
        for(exp in expList?: emptyList()){
            //Log.d("tttestskill",skill.skill.toString())
        }

    }

    object NULL_TO_EMPTY_STRING_ADAPTER {
        @FromJson
        fun fromJson(reader: JsonReader): String {
            if (reader.peek() != JsonReader.Token.NULL) {
                return reader.nextString()
            }
            reader.nextNull<Unit>()
            return ""
        }
    }
    //private val _text = MutableLiveData<String>().apply {
    //    value = "This is dashboard Fragment"
    //}
    //val text: LiveData<String> = _text

}