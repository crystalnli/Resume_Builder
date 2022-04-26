package com.example.resumebuilder

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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
        val path = context?.filesDir
        binding.addResume.setOnClickListener{
            if(ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
                )==PackageManager.PERMISSION_GRANTED){
                //DataProcess.generatePDF("test","test")
                view?.let { it1 -> DataProcess.pdf(it1,path) }
            }
            else{
                requestPermissions(arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                ),15)
            }
                }

        return root;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.isNotEmpty()
            &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Permission granted ", Toast.LENGTH_SHORT).show()
            Log.d("y","hhhhhh")
        }
        else{
            Log.d("n","ooooo")
            Toast.makeText(context, "Permission denied ", Toast.LENGTH_SHORT).show()
        }
    }

}