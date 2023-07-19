package com.example.mvvmdemo.repository

import androidx.lifecycle.MutableLiveData

class MockRepository {

    val mDataLiveData = MutableLiveData<String>()

    private var mFetchSuccess = true


    fun mockFetchDataFromRemoteServer() {
        if (mFetchSuccess) {
            mDataLiveData.postValue("成功获取到远程server的模拟数据")
        } else {
            mDataLiveData.postValue("网络请求失败")
        }
    }


    fun mockFetchDataFromCallBack(
        success: (result: String) -> Unit,
        error: (error: String) -> Unit
    ) {
        if (mFetchSuccess) {
            success.invoke("成功获取到回调方法的模拟数据")
        } else {
            error.invoke("回调方法请求失败")
        }

    }
}