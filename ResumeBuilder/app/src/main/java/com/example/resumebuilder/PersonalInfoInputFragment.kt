package com.example.resumebuilder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.resumebuilder.databinding.FragmentPersonalInfoInputBinding
import android.content.Context
import android.widget.Toast
import com.example.resumebuilder.models.PersonalInfo
import com.google.gson.Gson
import java.io.FileInputStream

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalInfoInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private lateinit var binding: FragmentPersonalInfoInputBinding
class PersonalInfoInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalInfoInputBinding.inflate(layoutInflater)
        val filename = "PI"
        val root = binding.root
        val path = context?.filesDir
        var gson = Gson()
        val data = DataProcess.read(path,filename)
        if (data!=""){
            var dataFromFile = gson.fromJson(data, PersonalInfo::class.java)
            binding.editName.setText(dataFromFile.editName)
            binding.editPhone.setText(dataFromFile.editPhone)
            binding.editEmailAddress.setText(dataFromFile.editEmailAddress)
            binding.editAddress.setText(dataFromFile.editAddress)
        }


        binding.cancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_personalInfoInputFragment_to_profileFragment)
        }
        binding.save.setOnClickListener {
            var name = binding.editName.getText()
            var phone = binding.editPhone.getText()
            var email = binding.editEmailAddress.getText()
            var address = binding.editAddress.getText()
            if (name.length != 0 && phone.length!=0 && email.length!=0 && address.length!=0) {
                var data = PersonalInfo(name.toString(), phone.toString(), email.toString(), address.toString())

                var fileContents: String = gson.toJson(data)
                DataProcess.write(path, filename, fileContents)
                Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show()
                View.OnClickListener{ view -> view.findNavController() .navigate(R.id.action_personalInfoInputFragment_to_profileFragment)
                }
            }
            else{
                Toast.makeText(context, "Please fill all required section ", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

}