package com.example.mvvmdemo.fragment

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_lib.src.fragment.BaseViewModeDataBindingFragment
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.FragmentViewModelPagerBinding


class ViewModelPagerDataBindingFragment :
    BaseViewModeDataBindingFragment<FragmentViewModelPagerBinding,
            FragmentViewModel>(R.layout.fragment_view_model_pager) {

    lateinit var shareViewModel: FragmentShareViewModel

    override fun initVMData() {


    }

    override fun initView() {
        super.initView()
        setText()
        shareViewModel = ViewModelProvider(requireActivity())[FragmentShareViewModel::class.java]

        mBinding.btnGetShare.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "获取到的共享值是" + shareViewModel.shareValue,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText() {
        arguments?.takeIf {
            it.containsKey(ARG_OBJECT)
        }?.apply {
            mBinding.tvContent.text = "ViewModelFragment " + getInt(ARG_OBJECT).toString()
        }
    }

}