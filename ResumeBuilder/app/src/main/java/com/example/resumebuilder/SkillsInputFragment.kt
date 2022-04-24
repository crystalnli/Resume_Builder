package com.example.resumebuilder

import com.example.resumebuilder.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.databinding.FragmentSkillsInputBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SkillsInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


private lateinit var recyclerView : RecyclerView
private lateinit var binding: FragmentSkillsInputBinding
private lateinit var skills: ArrayList<String>
class SkillsInputFragment : Fragment() {
    var fileName = "skills"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val path = context?.filesDir
            var data = DataProcess.read(path,fileName)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSkillsInputBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_skills_input,container,false)
        recyclerView= binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        //var adapter //= skillListAdapter(requireContext(),it)
        //recyclerView.adapter = adapter
        var root = binding.root
        binding.back.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_skillsInputFragment_to_profileFragment)
        }
        return root
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