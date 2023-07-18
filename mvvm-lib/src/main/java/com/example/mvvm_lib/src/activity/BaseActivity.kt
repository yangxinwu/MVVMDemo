package com.example.mvvm_lib.src.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(@LayoutRes layoutId: Int = 0) :
    AppCompatActivity() {

    private var mLayoutId = layoutId
    lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val childView = layoutInflater.inflate(mLayoutId, null)
        mBinding = DataBindingUtil.bind(childView)!!

        setContentView(mBinding.root)
        initData()
        initView()

    }


    abstract fun initView()

    abstract fun initData()

}