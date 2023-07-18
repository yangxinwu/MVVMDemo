package com.example.mvvmdemo.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel :BaseViewModel(){

     var loginInfo = MutableLiveData<LoginInfo>()

     private var _showProgress = MutableLiveData<Boolean>()
     var showProgress:LiveData<Boolean> = _showProgress

     fun login(){
          viewModelScope.launch {

               _showProgress.postValue(true)

               delay(5000) // 模拟登陆请求

               _showProgress.postValue(false)
          }
     }

}