package com.example.uasAPI.ui.bugs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasAPI.R
import com.example.uasAPI.databinding.FragmentListBugsBinding
import com.example.uasAPI.ui.MyViewModel

class ListBugsFragment: Fragment() {
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBugsBinding.inflate(inflater)
        myViewModel.getBugsList()
        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        binding.recyclerView.adapter = BugsListAdapter(BugsListener { bugs ->
            myViewModel.onBugsCLicked(bugs)
            findNavController()
                .navigate(R.id.action_listBugsFragment_to_detailBugsFragment)
        })
        return binding.root
    }


}