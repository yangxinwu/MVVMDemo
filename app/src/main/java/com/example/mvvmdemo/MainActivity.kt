package com.example.mvvmdemo



import android.content.Intent
import com.example.mvvm_lib.src.activity.BaseActivity
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.login.LoginBaseViewModelActivity
import com.example.mvvmdemo.recycleview.RecycleViewDemoActivity


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        mBinding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginBaseViewModelActivity::class.java))
        }

        mBinding.btnRecycleView.setOnClickListener {
            startActivity(Intent(this, RecycleViewDemoActivity::class.java))
        }
    }

    override fun initData() {

    }

}

