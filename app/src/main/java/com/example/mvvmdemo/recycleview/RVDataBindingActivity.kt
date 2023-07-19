package com.example.mvvmdemo.recycleview

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mvvm_lib.src.activity.BaseViewModeDataBindingActivity
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityRecycleviewBinding

class RVDataBindingActivity :
    BaseViewModeDataBindingActivity<ActivityRecycleviewBinding, RVViewModel>(R.layout.activity_recycleview) {
    override fun initVMData() {
        mViewModel.getPictureInfo()
    }

    override fun initView() {
        mBinding.adapter = RVAdapter(emptyList())
        mBinding.recyclerPicture.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL
            )
        )

        mBinding.ivClose.setOnClickListener {
            finish()
        }
    }

    override fun getVariableId(): Int {
        return BR.viewModel
    }
}