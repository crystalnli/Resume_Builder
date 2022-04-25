package com.example.resumebuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.resumebuilder.databinding.FragmentSettingBinding

private lateinit var binding:FragmentSettingBinding
class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        val root = binding.root
        val about = binding.about
        val text = binding.editTextTextMultiLine
        text.setText("ResumeBuilder version 1.0")
        val back = binding.back
        about.setOnClickListener{
            about.isVisible = false
            text.isVisible = true
            back.isVisible = true

        }

        back.setOnClickListener{
            about.isVisible = true
            text.isVisible = false
            back.isVisible = false
        }

        return root
    }

}