package com.example.mvvmdemo.recycleview

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mvvm_lib.src.activity.BaseVMActivity
import com.example.mvvmdemo.BR
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityRecycleviewBinding

class RVActivity :
    BaseVMActivity<ActivityRecycleviewBinding, RVViewModel>(R.layout.activity_recycleview) {
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
    }

    override fun getVariableId(): Int {
        return BR.viewModel
    }
}