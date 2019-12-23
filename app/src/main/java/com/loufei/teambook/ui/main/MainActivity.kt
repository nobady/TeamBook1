package com.loufei.teambook.ui.main

import com.loufei.base.ext.contentView
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityMainBinding
import com.loufei.teambook.ui.main.viewmodel.MainViewModel

class MainActivity : BaseVMActivity<MainViewModel>() {

    private val binding by contentView<MainActivity,ActivityMainBinding>(R.layout.activity_main)

    override fun getLayoutResId() = R.layout.activity_main

    override fun providerVMClass() = MainViewModel::class.java

    override fun initView() {
        binding.lifecycleOwner = this
        binding.mainModel = mViewModel
    }

    override fun initData() {
        binding.mainRecyclerView.adapter
    }


}
