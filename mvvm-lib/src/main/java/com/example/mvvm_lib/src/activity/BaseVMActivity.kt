package com.example.mvvm_lib.src.activity

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import java.lang.reflect.ParameterizedType


abstract class BaseVMActivity<VB : ViewDataBinding, BM : BaseViewModel>(@LayoutRes layoutId: Int = 0) :
    BaseActivity<VB>(layoutId) {

    lateinit var mViewModel: BM

    override fun initData() {
        mViewModel = getViewModel()!!
        val variableId = getVariableId()
        if (variableId != -1) {
            mBinding.setVariable(getVariableId(), mViewModel)
            mBinding.executePendingBindings()
        }
        mBinding.lifecycleOwner = this
        initVMData()
        observeLiveData()
        lifecycle.addObserver(mViewModel)
    }

    open fun getVariableId(): Int {
        return -1
    }

    abstract fun initVMData()

    open fun observeLiveData() {

    }

    private fun getViewModel(): BM? {
        val type = javaClass.genericSuperclass
        if (type != null && type is ParameterizedType) {
            val actualTypeArguments = type.actualTypeArguments
            val tClass = actualTypeArguments[1]
            return ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            )[tClass as Class<BM>]
        }
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            lifecycle.removeObserver(mViewModel)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}