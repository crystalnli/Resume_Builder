package com.example.resumebuilder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.resumebuilder.databinding.FragmentProfileBinding


private lateinit var binding: FragmentProfileBinding
private const val TAG = "MyActivity"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        val root: View = binding.root
         binding.personInfo.setOnClickListener { view: View ->
             view.findNavController()
                 .navigate(R.id.action_profileFragment_to_personalInfoInputFragment)
         }
        binding.education.setOnClickListener {
                view: View ->
            view.findNavController()
                .navigate(R.id.action_profileFragment_to_personalInfoInputFragment)
        }
        binding.skills.setOnClickListener {
                view: View ->
            view.findNavController()
                .navigate(R.id.action_profileFragment_to_skillsInputFragment)
        }
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

}