package com.example.mvvmdemo.login

import android.annotation.SuppressLint
import android.view.View
import com.example.mvvm_lib.src.activity.BaseVMActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.databinding.ActivityLoginBinding

class LoginBaseViewModelActivity :
    BaseVMActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override fun initVMData() {
        mViewModel.loginInfo.value = LoginInfo("test", "1234")
    }

    override fun getVariableId(): Int {
        return BR.loginViewModel
    }


    override fun initView() {

    }

    override fun observeLiveData() {
        super.observeLiveData()

        mViewModel.showProgress.observe(
            this
        ) { showProgress ->
            if (showProgress) {
                mBinding.clProgress.visibility = View.VISIBLE
            } else {
                mBinding.clProgress.visibility = View.GONE
                showResult()
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showResult() {
        mBinding.textResult.visibility = View.VISIBLE
        val userNameStr = mViewModel.loginInfo.value?.userName
        val passwordStr = mViewModel.loginInfo.value?.passWard
        mBinding.textResult.text = "登陆结果：${userNameStr} + $passwordStr"
    }


}

