package com.example.mvvm_lib.src.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * 对Adapter进行基础封装 方便DataBinding实现
 */
abstract class BaseAdapter<VDB : ViewDataBinding, T : ListAdapterItem>(
    var data: List<T>
) : RecyclerView.Adapter<BaseViewHolder<VDB>>() {

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun bind(holder: BaseViewHolder<VDB>, item: T)

    fun updateData(list: List<T>) {
        this.data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> {
        val binder = DataBindingUtil.inflate<VDB>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )

        return BaseViewHolder(binder)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        bind(holder, data[position])
    }

    override fun getItemCount(): Int = data.size
}