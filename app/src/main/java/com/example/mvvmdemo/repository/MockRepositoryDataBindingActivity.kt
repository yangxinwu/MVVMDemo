package com.example.mvvmdemo.repository

import android.widget.Toast
import com.example.mvvm_lib.src.activity.BaseViewModeDataBindingActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityRepositoryBinding

class MockRepositoryDataBindingActivity :
    BaseViewModeDataBindingActivity<ActivityRepositoryBinding, MockRepositoryViewModel>(R.layout.activity_repository) {

    override fun initView() {
        mBinding.ivClose.setOnClickListener {
            finish()
        }
    }

    override fun initVMData() {
        mBinding.btnLiveData.setOnClickListener {
            mViewModel.mockFetchDataFromRemoteServer()
        }

        mBinding.btnCallBack.setOnClickListener {
            mViewModel.mockFetchDataFromCallBack({
                //成功
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }, {
                //失败
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    /**
     *监听LiveData发生的改变
     */
    override fun observeLiveData() {
        super.observeLiveData()
        mViewModel.getLiveData()?.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }


}