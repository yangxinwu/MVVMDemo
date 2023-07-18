package com.example.mvvmdemo.recycleview

import com.example.mvvm_lib.src.adapter.BaseAdapter
import com.example.mvvmdemo.R
import com.example.mvvmdemo.bean.PictureInfo
import com.example.mvvmdemo.databinding.RecycleViewItemLayoutBinding

class RVAdapter(private val list:List<PictureInfo>):BaseAdapter<RecycleViewItemLayoutBinding,PictureInfo>(list) {
    override val layoutId: Int
        get() = R.layout.recycle_view_item_layout

    override fun bind(binding: RecycleViewItemLayoutBinding, item: PictureInfo) {
        binding.apply {
            pictureInfo = item
            executePendingBindings()
        }
    }
}