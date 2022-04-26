package com.example.resumebuilder.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.BuildConfig.DEBUG
import com.example.resumebuilder.BuildConfig.DEBUG
import com.example.resumebuilder.DataProcess
import com.example.resumebuilder.models.PersonalInfo
import com.example.resumebuilder.models.Skill
import com.squareup.moshi.*


class SkillViewModel(app: Application) : AndroidViewModel(app) {
    val fileName = "skill.json"
    val skillData = MutableLiveData<List<Skill>>()
    private val listType = Types.newParameterizedType(
        List::class.java,Skill::class.java
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
        val adapter: JsonAdapter<List<Skill>> = moshi.adapter(listType)
        val skillList = adapter.fromJson(data)
        skillData.value = adapter.fromJson(data)?:emptyList()
        for(skill in skillList?: emptyList()){
            Log.d("tttestskill",skill.skill.toString())
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
}