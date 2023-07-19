package com.example.mvvmdemo.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm_lib.src.event.LiveEvent
import com.example.mvvm_lib.src.event.SingleLiveEvent
import com.example.mvvm_lib.src.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel :BaseViewModel(){

     var loginInfo = MutableLiveData<LoginInfo>()

     var account = MutableLiveData<String>()
     var password = MutableLiveData<String>()

     private var _showProgress = MutableLiveData<Boolean>()
     var showProgress:LiveData<Boolean> = _showProgress

     var showLoginToastEvent = MutableLiveData<Boolean>(false)
     var showLoginToastSingleEvent = SingleLiveEvent<Boolean>()


     var showLoginToastMoreObserverEvent = LiveEvent<Boolean>()



     fun login(){
          viewModelScope.launch {

               _showProgress.postValue(true)

               delay(1000) // 模拟登陆请求

               _showProgress.postValue(false)

               loginInfo.postValue(LoginInfo(account.value!!,password.value!!))

               //showLoginToastEvent.value = true

               //showLoginToastSingleEvent.value = true

               showLoginToastMoreObserverEvent.value = true
          }
     }

     override fun onCreate() {
          super.onCreate()
          Log.d("LoginViewModel","---------------onCreate---------------")
     }

     override fun onStart() {
          super.onStart()
          Log.d("LoginViewModel","---------------onStart---------------")
     }

     override fun onResume() {
          super.onResume()
          Log.d("LoginViewModel","---------------onResume---------------")
     }


     override fun onPause() {
          super.onPause()
          Log.d("LoginViewModel","---------------onPause---------------")
     }

     override fun onDestroy() {
          super.onDestroy()
          Log.d("LoginViewModel","---------------onDestroy---------------")
     }

}