package com.loufei.teambook.ui.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.loufei.base.ext.loge
import com.loufei.base.ui.fragment.BaseVMFragment
import com.loufei.teambook.R
import com.loufei.teambook.databinding.FragHomeBinding
import com.loufei.teambook.weight.CommonToolbar

/**
 * Created by lvtengfei on 2019-12-26.
 */
class HomeFragment:BaseVMFragment<HomeViewModel,FragHomeBinding>() {


    private lateinit var mToolbar: CommonToolbar
    private val homeAdapter by lazy { HomeAdapter() }
    override fun getLayoutResId() = R.layout.frag_home

    override fun providerVMClass() = HomeViewModel::class.java

    override fun initView() {
        binding.model = mViewModel
        binding.root.toString().loge()
        mToolbar = binding.layoutTitle as CommonToolbar
        mToolbar.setArrowImage(R.drawable.ic_arrow_drop_down_black_24dp)

        binding.homeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.homeRecyclerView.adapter = homeAdapter
    }

    override fun initData() {
        mViewModel.currentBillBook.observe(this, Observer {
            mToolbar.setCenterText(it)
        })

        mViewModel.billDetailList.observe(this, Observer {
            homeAdapter.addAll(it,true)
        })

        mViewModel.getDetailData()
    }
}