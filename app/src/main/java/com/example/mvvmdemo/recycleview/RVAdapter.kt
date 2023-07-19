package com.example.mvvmdemo.recycleview

import android.util.Log
import com.example.mvvm_lib.src.adapter.BaseAdapter
import com.example.mvvm_lib.src.adapter.BaseViewHolder
import com.example.mvvmdemo.R
import com.example.mvvmdemo.bean.PictureInfo
import com.example.mvvmdemo.databinding.RecycleViewItemLayoutBinding

class RVAdapter(private val list:List<PictureInfo>):BaseAdapter<RecycleViewItemLayoutBinding,PictureInfo>(list) {
    override val layoutId: Int
        get() = R.layout.recycle_view_item_layout

    override fun bind(holder: BaseViewHolder<RecycleViewItemLayoutBinding>, item: PictureInfo) {
        holder.binder.apply {
            pictureInfo = item
            executePendingBindings()
        }

        holder.itemView.setOnClickListener {
            Log.d("RVAdapter","------------OnClick----------------${holder.adapterPosition}---")
        }


        holder.itemView.setOnLongClickListener {
            Log.d("RVAdapter","------------OnLongClick----------${holder.adapterPosition}---------")
            false
        }
    }
}