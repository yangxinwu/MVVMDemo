package com.example.mvvmdemo.fragment

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_lib.src.fragment.BaseDataBindingFragment
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.FragmentSimplePagerBinding


class SimplePagerFragment :
    BaseDataBindingFragment<FragmentSimplePagerBinding>(R.layout.fragment_simple_pager) {

    private lateinit var shareViewModel: FragmentShareViewModel


    override fun initData() {


    }

    override fun initView() {
        super.initView()
        setText()
        shareViewModel = ViewModelProvider(requireActivity())[FragmentShareViewModel::class.java]
        mBinding.btnShare.setOnClickListener {
            shareViewModel.shareValue = Math.random().toString()
            Toast.makeText(
                requireContext(), "设置的共享值是" + shareViewModel.shareValue, Toast.LENGTH_SHORT
            ).show()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun setText() {
        arguments?.takeIf {
            it.containsKey(ARG_OBJECT)
        }?.apply {
            mBinding.tvContent.text = "Fragment " + getInt(ARG_OBJECT).toString()
        }
    }

}