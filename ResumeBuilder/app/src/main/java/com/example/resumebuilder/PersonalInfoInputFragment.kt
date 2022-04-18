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
        val root: View = binding.root

        val filename = "savedData"

        val stream: FileInputStream? = context?.openFileInput(filename)
        val data = ByteArray(1024)
        stream?.read(data)
        stream?.close()

        Log.d("checktag",data.toString(Charsets.UTF_8))



        binding.cancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_personalInfoInputFragment_to_profileFragment)
        }

        var fileContents = ""
        binding.save.setOnClickListener {
            if(binding.editName.getText().length>0){

                val str = binding.editName.getText()
                 fileContents += "editName"+str.toString()
            }
            if (binding.editPhone.getText().length>0){
                val str = binding.editPhone.getText()
                fileContents += "editPhone"+str.toString()
                }
            if (fileContents!=""){
                Log.d("writedata",fileContents)
                context?.openFileOutput(filename, Context.MODE_PRIVATE).use {
                    it?.write(fileContents.toByteArray())
                }
            }
            else{
                Toast.makeText(context, "Please fill all required section ", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

}