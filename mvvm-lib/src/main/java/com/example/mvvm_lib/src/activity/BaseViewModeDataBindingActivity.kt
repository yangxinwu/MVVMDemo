package com.example.mvvm_lib.src.activity

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import java.lang.reflect.ParameterizedType


abstract class BaseViewModeDataBindingActivity<VDB : ViewDataBinding, BVM : BaseViewModel>(@LayoutRes layoutId: Int) :
    BaseDataBindingActivity<VDB>(layoutId) {

    lateinit var mViewModel: BVM

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

    private fun getViewModel(): BVM? {
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        val type = javaClass.genericSuperclass
        if (type != null && type is ParameterizedType) {
            //返回表示此类型实际类型参数的 Type 对象的数组
            val actualTypeArguments = type.actualTypeArguments
            //获取ViewModel的类型
            val tClass = actualTypeArguments[1]
            return ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            )[tClass as Class<BVM>]
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