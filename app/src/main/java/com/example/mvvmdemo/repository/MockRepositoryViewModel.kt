package com.example.mvvmdemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_lib.src.viewModel.BaseViewModel


class MockRepositoryViewModel : BaseViewModel() {

    /**
     * 获取需要的Repository
     */
    private val mRepository by lazy {
        getRepository<MockRepository>()
    }

    /**
     * 获取LiveData
     */
    fun getLiveData(): MutableLiveData<String>? {
        return mRepository?.mDataLiveData
    }

    /**
     *模拟从服务端获取数据
     */
    fun mockFetchDataFromRemoteServer() {
        mRepository?.mockFetchDataFromRemoteServer()
    }

    /**
     * 模拟从回调中获取数据
     */
    fun mockFetchDataFromCallBack(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        mRepository?.mockFetchDataFromCallBack({
            success.invoke(it)
        }, {
            error.invoke(it)
        })
    }
}