package com.example.mvvmdemo.recycleview

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_lib.src.adapter.BaseAdapter
import com.example.mvvm_lib.src.adapter.ListAdapterItem


@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView, adapter: BaseAdapter<ViewDataBinding, ListAdapterItem>?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<ListAdapterItem>?) {
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, ListAdapterItem>?
    adapter?.updateData(list ?: listOf())
}

@BindingAdapter("showProgressBar")
fun manageState(progressBarView: ConstraintLayout, visible: Boolean) {
    progressBarView.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, image: Int) {
    Log.d("setImage","-------------image------$image----")
    imageView.setBackgroundResource(image)
}