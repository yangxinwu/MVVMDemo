package com.example.mvvmdemo.recycleview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import com.example.mvvmdemo.MockData
import com.example.mvvmdemo.bean.PictureInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RVViewModel :BaseViewModel(){

    private val _pictureInfoList = MutableLiveData<List<PictureInfo>>()
    val pictureInfoList: LiveData<List<PictureInfo>> = _pictureInfoList

    private val _showProgressBar = MutableLiveData(false)
    val showProgressBar: LiveData<Boolean> = _showProgressBar


    fun getPictureInfo(){
        viewModelScope.launch {
            fetchPictureInfo().onStart {
                _showProgressBar.postValue(true)
            }.catch {
                _showProgressBar.postValue(false)
            }.collect{
                _showProgressBar.postValue(false)
                _pictureInfoList.value = it
            }
        }
    }


    private fun fetchPictureInfo() = flow<List<PictureInfo>> {
            delay(1000)
            emit(MockData.pictureInfoList)
    }.flowOn(Dispatchers.IO)

}