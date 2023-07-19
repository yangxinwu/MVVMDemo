package com.example.mvvmdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.mvvm_lib.src.activity.BaseDataBindingActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityViewPagerBinding


@Suppress("DEPRECATION")
class TestPagerDataBindingActivity : BaseDataBindingActivity<ActivityViewPagerBinding>(R.layout.activity_view_pager) {

    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter

    override fun initView() {
        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(supportFragmentManager)
        mBinding.viewPager.adapter = demoCollectionPagerAdapter
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
    }

    override fun initData() {

    }

}

const val ARG_OBJECT = "标题"

class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 4

    override fun getItem(i: Int): Fragment {
        val fragment = if (i % 2 == 0) SimplePagerFragment() else ViewModelPagerFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, i + 1)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "标题 ${(position + 1)}"
    }
}


