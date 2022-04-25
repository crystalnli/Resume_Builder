package com.example.resumebuilder

import com.example.resumebuilder.*
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.adapters.SkillListAdapter
import com.example.resumebuilder.databinding.FragmentSkillsInputBinding
import com.example.resumebuilder.models.Skill
import com.example.resumebuilder.ui.SkillViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SkillsInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


private lateinit var recyclerView : RecyclerView
private lateinit var binding: FragmentSkillsInputBinding
private lateinit var viewModel: SkillViewModel
class SkillsInputFragment : Fragment() , SkillListAdapter.SkillItemListener{
    var fileName = "skills"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val path = context?.filesDir
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkillsInputBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_skills_input,container,false)
        recyclerView= view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)
        viewModel.skillData.observe(viewLifecycleOwner, Observer {
            var adapter = SkillListAdapter(requireContext(),it,this)
            recyclerView.adapter = adapter

            //binding.back.setOnClickListener { view: View ->
            //    view.findNavController()
            //       .navigate(R.id.action_skillsInputFragment_to_profileFragment)
            //}
        })


        return view
    }

    override fun onSkillClick(skill: Skill) {
        Log.d("rrrrrrrr",skill.skill)
    }
    fun updateList(view: RecyclerView, data:String){
        if (data!=""){
            recyclerView.isVisible = true
            var dataFromFile = data!!.split("\n")
        }
        else{
            recyclerView.isVisible = false
        }
    }

}