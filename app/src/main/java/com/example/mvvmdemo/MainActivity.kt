package com.example.mvvmdemo



import android.content.Intent
import com.example.mvvm_lib.src.activity.BaseActivity
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.activity.LoginBaseViewModelActivity
import com.example.mvvmdemo.fragment.TestPagerActivity
import com.example.mvvmdemo.recycleview.RVActivity
import com.example.mvvmdemo.repository.MockRepositoryActivity


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        mBinding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginBaseViewModelActivity::class.java))
        }

        mBinding.btnRecycleView.setOnClickListener {
            startActivity(Intent(this, RVActivity::class.java))
        }

        mBinding.btnFragment.setOnClickListener {
            startActivity(Intent(this, TestPagerActivity::class.java))
        }

        mBinding.btnMockRepository.setOnClickListener {
            startActivity(Intent(this, MockRepositoryActivity::class.java))
        }
    }

    override fun initData() {

    }

}

