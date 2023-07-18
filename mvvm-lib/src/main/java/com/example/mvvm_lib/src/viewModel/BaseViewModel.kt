package com.example.mvvm_lib.src.viewModel

import androidx.lifecycle.ViewModel
import com.example.mvvm_lib.src.observer.BaseObserver

open class BaseViewModel : ViewModel(), BaseObserver {

    inline fun <reified R> getRepository(): R? {
        try {
            val clazz = R::class.java
            return clazz.newInstance()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }


    override fun onPause() {

    }


    override fun onStop() {

    }

    override fun onDestroy() {
    }
}