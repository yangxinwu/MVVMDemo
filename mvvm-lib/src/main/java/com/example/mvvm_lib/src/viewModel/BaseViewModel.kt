package com.example.mvvm_lib.src.viewModel

import androidx.lifecycle.ViewModel
import com.example.mvvm_lib.src.lifecycle.BaseLifeCycleObserver

open class BaseViewModel : ViewModel(), BaseLifeCycleObserver {

    //使用reified 作用于函数上, 类型擦除后的再生，便于使用泛型以及获取方法的泛型类型。
    inline fun <reified R> getRepository(): R? {
        try {
            //通过反射获取 Repository 仓库实例
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