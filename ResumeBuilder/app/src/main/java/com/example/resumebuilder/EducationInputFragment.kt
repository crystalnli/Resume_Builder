package com.example.resumebuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.resumebuilder.databinding.FragmentEducationInputBinding
import com.example.resumebuilder.models.Education
import com.google.gson.Gson


private lateinit var binding: FragmentEducationInputBinding
class EducationInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationInputBinding.inflate(layoutInflater)
        val filename = "Edu"
        val root = binding.root
        val path = context?.filesDir
        var gson = Gson()
        val data = DataProcess.read(path,filename)
        if (data!=""){
            var dataFromFile = gson.fromJson(data, Education::class.java)
            binding.editSchoolName.setText(dataFromFile.school)
            binding.editDegree.setText(dataFromFile.degree)
            binding.editYearFrom.setText(dataFromFile.yearFrom)
            binding.editYearTo.setText(dataFromFile.yearTo)
        }


        binding.cancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_educationInputFragment_to_profileFragment)
        }
        binding.save.setOnClickListener {
            var school = binding.editSchoolName.getText()
            var degree = binding.editDegree.getText()
            var yf = binding.editYearFrom.getText()
            var yt = binding.editYearTo.getText()
            if (school.length != 0 && degree.length!=0 && yf.length!=0 && yt.length!=0) {
                var data = Education(school.toString(), degree.toString(), yf.toString(), yt.toString())
                var fileContents: String = gson.toJson(data)
                DataProcess.write(path, filename, fileContents)
                Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show()
                view?.findNavController()?.navigate(R.id.action_educationInputFragment_to_profileFragment)


            }
            else{
                Toast.makeText(context, "Please fill all required section ", Toast.LENGTH_SHORT).show()
            }
        }
        return root}

}