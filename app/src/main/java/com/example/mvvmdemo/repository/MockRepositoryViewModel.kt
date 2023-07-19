package com.example.mvvmdemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_lib.src.viewModel.BaseViewModel


class MockRepositoryViewModel : BaseViewModel() {

    /**
     * 获取需要的Repository
     */
    private val repository by lazy {
        getRepository<MockRepository>()
    }

    /**
     * 获取LiveData
     */
    fun getLiveData(): MutableLiveData<String>? {
        return repository?.mResultLiveData
    }

    /**
     *LiveData进行返回数据,模拟网络请求
     */
    fun doHttpLiveData() {
        repository?.doHttpLiveData()
    }

    /**
     * 模拟数据请求，真实情况，请以实际业务为主
     */
    fun doHttpCallback(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        repository?.doHttpCallback({
            success.invoke(it)
        }, {
            error.invoke(it)
        })
    }
}