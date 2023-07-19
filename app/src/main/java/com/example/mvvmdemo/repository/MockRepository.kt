package com.example.mvvmdemo.repository

import androidx.lifecycle.MutableLiveData

class MockRepository {

    val mResultLiveData = MutableLiveData<String>()

    private var mIsSuccess = true


    fun doHttpLiveData() {
        if (mIsSuccess) {
            mResultLiveData.postValue("我是LiveData方式模拟数据")
        } else {
            mResultLiveData.postValue("网络请求失败")
        }
    }


    fun doHttpCallback(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        if (mIsSuccess) {
            success.invoke("我是回调方式模拟数据")
        } else {
            error.invoke("我是回调方式的网络请求失败")
        }

    }
}