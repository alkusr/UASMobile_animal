package com.example.uasAPI.ui.sea

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uasAPI.databinding.ListViewTemSeaBinding
import com.example.uasAPI.network.Sea

class SeaListAdapter(private val clickListener: SeaListener):
ListAdapter<Sea.Data, SeaListAdapter.SeaViewHolder>(DiffCallback){
    class SeaViewHolder(var binding: ListViewTemSeaBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(clickListener: SeaListener, sea: Sea.Data){
                    binding.sea = sea
                    binding.clicklistener = clickListener
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallback: DiffUtil.ItemCallback<Sea.Data>() {
        override fun areItemsTheSame(
            oldItem: Sea.Data,
            newItem: Sea.Data
        ): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(
            oldItem: Sea.Data,
            newItem: Sea.Data
        ): Boolean {
            return oldItem.nama == newItem.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SeaViewHolder(
            ListViewTemSeaBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SeaViewHolder, position: Int) {
        val sea = getItem(position)
        holder.bind(clickListener, sea)
    }
}


class SeaListener(val clicklistener: (sea: Sea.Data)-> Unit){
    fun onCLick(sea: Sea.Data) = clicklistener(sea)
}