package com.example.uasAPI

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.example.uasAPI.network.Sea
import com.example.uasAPI.network.Bugs
import com.example.uasAPI.network.Fish
import com.example.uasAPI.ui.ApiStatus
import com.example.uasAPI.ui.sea.SeaListAdapter
import com.example.uasAPI.ui.FishListAdapter
import com.example.uasAPI.ui.bugs.BugsListAdapter


@BindingAdapter("listData")
fun bindRecyclerViewFish(recyclerView: RecyclerView, data: List<Fish.Data>?) {
    val adapter = recyclerView.adapter as FishListAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataSea")
fun bindRecyclerViewSea(recyclerView: RecyclerView, data: List<Sea.Data>?) {
    val adapter = recyclerView.adapter as SeaListAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataBugs")
fun bindRecyclerViewBugs(recyclerView: RecyclerView, data: List<Bugs.Data>?) {
    val adapter = recyclerView.adapter as BugsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun apiStatus(shimmerFrameLayout: ShimmerFrameLayout, status: ApiStatus?){
    when(status){
        ApiStatus.DONE->{
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        }
    }
}