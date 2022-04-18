package com.example.resumebuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.resumebuilder.databinding.FragmentProfileBinding
import com.example.resumebuilder.databinding.FragmentResumeBinding

private lateinit var binding: FragmentResumeBinding

class ResumeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumeBinding.inflate(layoutInflater)
        val root: View = binding.root

        binding.addResume.setOnClickListener{
                view: View ->
            view.findNavController()
                .navigate(R.id.action_resumeFragment_to_profileFragment)
        }

        return root;
    }

}