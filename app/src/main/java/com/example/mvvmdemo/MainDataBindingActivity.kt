package com.example.mvvmdemo



import android.content.Intent
import com.example.mvvm_lib.src.activity.BaseDataBindingActivity
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.activity.LoginBaseViewModelDataBindingActivity
import com.example.mvvmdemo.fragment.TestPagerDataBindingActivity
import com.example.mvvmdemo.recycleview.RVDataBindingActivity
import com.example.mvvmdemo.repository.MockRepositoryDataBindingActivity


class MainDataBindingActivity : BaseDataBindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun initView() {
        mBinding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginBaseViewModelDataBindingActivity::class.java))
        }

        mBinding.btnRecycleView.setOnClickListener {
            startActivity(Intent(this, RVDataBindingActivity::class.java))
        }

        mBinding.btnFragment.setOnClickListener {
            startActivity(Intent(this, TestPagerDataBindingActivity::class.java))
        }

        mBinding.btnMockRepository.setOnClickListener {
            startActivity(Intent(this, MockRepositoryDataBindingActivity::class.java))
        }
    }

    override fun initData() {

    }

}

