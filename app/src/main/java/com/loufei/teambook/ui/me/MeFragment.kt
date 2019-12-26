package com.loufei.teambook.ui.me

import com.loufei.base.ui.fragment.BaseVMFragment
import com.loufei.teambook.R
import com.loufei.teambook.databinding.FragMeBinding

/**
 * Created by lvtengfei on 2019-12-26.
 */
class MeFragment:BaseVMFragment<MeViewModel,FragMeBinding>() {
    override fun getLayoutResId() = R.layout.frag_me
    override fun providerVMClass() = MeViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
    }
}