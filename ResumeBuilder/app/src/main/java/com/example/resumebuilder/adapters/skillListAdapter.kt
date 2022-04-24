package com.example.resumebuilder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.R

class skillListAdapter (val context: Context, val skills:List<String>):
RecyclerView.Adapter<skillListAdapter.ViewHolder>(){


    override fun getItemCount(): Int {
        return skills.size
    }

    inner class ViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView){
                var etext = itemView.findViewById<EditText>(R.id.textToDisplay)

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val view = inflater.inflate(R.layout.text_with_option,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = skills[position]
    }


}