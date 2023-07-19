package com.example.mvvmdemo.activity

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mvvm_lib.src.activity.BaseViewModeDataBindingActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.bean.LoginInfo
import com.example.mvvmdemo.databinding.ActivityLoginBinding

class LoginViewModelActivity :
    BaseViewModeDataBindingActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override fun initVMData() {
        mViewModel.account.value = "test"
        mViewModel.password.value = "12345"
    }

    override fun getVariableId(): Int {
        return BR.loginViewModel
    }

    override fun initView() {
        mBinding.ivClose.setOnClickListener {
            finish()
        }
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
            }
        }


        mViewModel.account.observe(this) {
            Log.d("TAG", "-------------------User name is $it")
        }

        mViewModel.password.observe(this) {
            Log.d("TAG", "-------------------PassWord is $it")
        }


        mViewModel.loginInfo.observe(this) {
            showResult(it)
        }

        //liveData 数据倒灌,每次配置变化，重建Activity，因为LiveData具有粘性所以会导致该事件再次触发
        mViewModel.showLoginToastEvent.observe(this){
            if (it){
                Toast.makeText(this,"Login 成功",Toast.LENGTH_SHORT).show()
            }
        }

        //SingleLiveEvent解决了数据倒灌的问题，原理是给事件增加状态判断，缺点是只能由一个观察者，
        // 因为SingleLiveEvent的状态是共用的
        mViewModel.showLoginToastSingleEvent.mObserve(this){
            if (it == true){
                Log.d("SingleEvent", "-------------------showLoginToastSingleEvent onChange")
                Toast.makeText(this,"SingleEvent Login 成功",Toast.LENGTH_SHORT).show()
            }
        }

        //再次注册监听器,无法接收到响应
        mViewModel.showLoginToastSingleEvent.mObserve(this){
            if (it == true){
                Log.d("SingleEvent", "-------------------showLoginToastSingleEvent2 onChange")
                Toast.makeText(this,"SingleEvent2 Login 成功",Toast.LENGTH_LONG).show()
            }
        }


        //LiveEvent 支持多观察者的单次事件
        mViewModel.showLoginToastMoreObserverEvent.observe(this){
            if (it == true){
                Log.d("SingleEvent", "-------------------showLoginToastMoreObserverEvent onChange")
                Toast.makeText(this,"showLoginToastMoreObserverEvent Login 成功",Toast.LENGTH_SHORT).show()
            }
        }

        mViewModel.showLoginToastMoreObserverEvent.observe(this){
            if (it == true){
                Log.d("SingleEvent", "---------2----------showLoginToastMoreObserverEvent onChange")
                Toast.makeText(this,"showLoginToastMoreObserverEvent2 Login 成功",Toast.LENGTH_LONG).show()
            }
        }

    }


    @SuppressLint("SetTextI18n")
    private fun showResult(loginInfo: LoginInfo) {
        mBinding.textResult.visibility = View.VISIBLE
        val userNameStr = loginInfo.userName
        val passwordStr = loginInfo.passWard
        mBinding.textResult.text = "账户信息  账户：$userNameStr  密码：$passwordStr"
    }


}

