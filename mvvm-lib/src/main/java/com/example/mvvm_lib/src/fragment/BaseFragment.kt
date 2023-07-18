package com.example.mvvm_lib.src.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseFragment<VB : ViewDataBinding>(@LayoutRes layoutId: Int = 0) :
    Fragment(layoutId) {

    lateinit var mBinding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DataBindingUtil.bind(view)!!
        initView()
        initData()
    }

    open fun initView() {}

    abstract fun initData()

}