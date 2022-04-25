package com.example.resumebuilder.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.R
import com.example.resumebuilder.models.Experience

class ExperienceAdapter(val expList:List<Experience>,private val listener: (Experience) -> Unit) : RecyclerView.Adapter<ExperienceAdapter.ViewHolder>(){


      /*  var yearFrom: TextView
        //var yearTo: EditText

        val yFrom = arrayOf("s","d","r")
        init {
            yearFrom = itemView.findViewById(R.id.editYearFrom)
            //yearTo = itemView.findViewById(R.id.editYearTo)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, Experience::class.java).apply {
                   // putExtra("NUMBER", position)
                    Log.d("qqqq",yearFrom.toString())
                }
                context.startActivity(intent)
            }
        }*/


    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.editYearFrom)
        fun bind(item: Experience) {
            name.text = item.yearFrom.toString()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.editable_detail, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = expList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int  = expList.size

}