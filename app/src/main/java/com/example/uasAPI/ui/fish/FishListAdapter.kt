package com.example.uasAPI.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewItemFishBinding
import com.example.uasAPI.network.Fish

class FishListAdapter(private val clickListener: FishListener) :
    ListAdapter<Fish.Data, FishListAdapter.FishViewHolder>(DiffCallback) {
    class FishViewHolder(var binding: ListViewItemFishBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: FishListener, fish: Fish.Data) {
            binding.fish = fish
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FishViewHolder(
            ListViewItemFishBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        val doa = getItem(position)
        holder.bind(clickListener, doa)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Fish.Data>() {
        override fun areItemsTheSame(oldItem: Fish.Data, newItem: Fish.Data): Boolean {
            return oldItem.rarity == newItem.rarity
        }

        override fun areContentsTheSame(oldItem: Fish.Data, newItem: Fish.Data): Boolean {
            return oldItem.rarity == newItem.rarity
        }

    }
}

class FishListener(val clickListener: (doa: Fish.Data) -> Unit) {
    fun onClick(doa: Fish.Data) = clickListener(doa)
}