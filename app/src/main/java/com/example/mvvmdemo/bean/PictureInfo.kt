package com.example.mvvmdemo.bean

import com.example.mvvm_lib.src.adapter.ListAdapterItem

data class PictureInfo(val url:Int, override val id: Long = 0):ListAdapterItem
