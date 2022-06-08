package com.example.uasAPI.ui.bugs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewTemBugsBinding
import com.example.uasAPI.network.Bugs

class BugsListAdapter(private val clickListener: BugsListener):
ListAdapter<Bugs.Data, BugsListAdapter.BugsViewHolder>(DiffCallback){
    class BugsViewHolder(var binding: ListViewTemBugsBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: BugsListener, bugs: Bugs.Data){
                    binding.bugs = bugs
                    binding.clicklistener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<Bugs.Data>() {
        override fun areItemsTheSame(
            oldItem: Bugs.Data,
            newItem: Bugs.Data
        ): Boolean {
            return oldItem.penerbit == newItem.penerbit
        }

        override fun areContentsTheSame(
            oldItem: Bugs.Data,
            newItem: Bugs.Data
        ): Boolean {
            return oldItem.penerbit == newItem.penerbit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BugsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BugsViewHolder(
            ListViewTemBugsBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BugsViewHolder, position: Int) {
        val bugs = getItem(position)
        holder.bind(clickListener, bugs)
    }
}


class BugsListener(val clicklistener: (bugs: Bugs.Data)-> Unit){
    fun onCLick(bugs: Bugs.Data) = clicklistener(bugs)
}