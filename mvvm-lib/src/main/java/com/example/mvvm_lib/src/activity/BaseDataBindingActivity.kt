package com.example.mvvm_lib.src.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * 快捷支持DataBinding的Activity基类
 */
abstract class BaseDataBindingActivity<VDB : ViewDataBinding>(@LayoutRes layoutId:Int) :
    AppCompatActivity() {

    private var mLayoutId = layoutId
    lateinit var mBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val childView = layoutInflater.inflate(mLayoutId, null)
        mBinding = DataBindingUtil.bind(childView)!!
        setContentView(mBinding.root)

        initData()
        initView()

    }

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }

}