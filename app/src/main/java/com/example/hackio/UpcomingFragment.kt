package com.example.hackio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hackio.databinding.FragmentUpcomingBinding


class UpcomingFragment : Fragment(),Uplisten {

    private val sharedViewModel: ContestViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentUpcomingBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.dataup = sharedViewModel
        // Giving the binding access to the OverviewViewModel
        // Sets the adapter of the photosGrid RecyclerView
        binding.recyclerViewup.adapter = Upadapter(this)

        return binding.root

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpcomingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onclicked(hit: ContestsItem) {
        val bundle = Bundle().apply {
            putSerializable("contest", hit)
        }
        findNavController().navigate(R.id.action_upcomingFragment_to_displayFragment, bundle)
    }

}