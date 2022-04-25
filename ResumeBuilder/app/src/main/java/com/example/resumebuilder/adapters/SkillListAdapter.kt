package com.example.resumebuilder.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.R
import com.example.resumebuilder.models.Skill

class SkillListAdapter (val context: Context, val skills:List<Skill>,val itemListener: SkillItemListener): RecyclerView.Adapter<SkillListAdapter.ViewHolder>(){


    override fun getItemCount(): Int {
        return skills.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.text_with_option,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = skills[position]
        with(holder){
            etext?.let{
                Log.d("tttttttt","ssss")
                it.setText(skill.skill, TextView.BufferType.EDITABLE)
            }
            holder.itemView.setOnClickListener{
                itemListener.onSkillClick(skill)
            }
        }
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val etext = itemView.findViewById<EditText>(R.id.textToDisplay)
        val editBtn = itemView.findViewById<Button>(R.id.editskill)
        val delBtn = itemView.findViewById<Button>(R.id.deleteSkill)
    }

    interface SkillItemListener{
        fun onSkillClick(skill:Skill){

        }
    }


}