package com.example.resumebuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resumebuilder.adapters.ExperienceAdapter
import com.example.resumebuilder.models.Experience

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExperienceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExperienceFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ExperienceAdapter.ViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    /*override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        expRec.apply {
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            adapter = ExperienceAdapter(expList)
        }
    }*/

}