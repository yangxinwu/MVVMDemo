package com.example.mvvm_lib.src.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseDataBindingFragment<VDB : ViewDataBinding>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    lateinit var mBinding: VDB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DataBindingUtil.bind(view)!!
        initView()
        initData()
    }

    open fun initView() {}

    abstract fun initData()

    override fun onDetach() {
        super.onDetach()
        mBinding.unbind()
    }

}