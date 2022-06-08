package com.example.uasAPI.ui.fish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasAPI.R
import com.example.uasAPI.databinding.FragmentListFishBinding
import com.example.uasAPI.ui.FishListAdapter
import com.example.uasAPI.ui.FishListener
import com.example.uasAPI.ui.MyViewModel

class ListFishFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListFishBinding.inflate(inflater)
        viewModel.getFishList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = FishListAdapter(FishListener { doa ->
            viewModel.onFishCLicked(doa)
            findNavController()
                .navigate(R.id.action_listFishFragment_to_detailFishFragment)
        })
        return binding.root
    }

}