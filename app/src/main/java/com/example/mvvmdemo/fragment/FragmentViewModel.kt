package com.example.mvvmdemo.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import com.example.mvvmdemo.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FragmentViewModel : BaseViewModel(){


    private var _imgData = MutableLiveData<Int>()
    var imgData:LiveData<Int> = _imgData


    fun getMockData(){
        viewModelScope.launch {
            delay(2000)
            _imgData.postValue(R.drawable.ic_launcher_foreground)
        }

    }


}