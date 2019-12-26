package com.loufei.teambook.ui.account

import com.loufei.base.ui.fragment.BaseVMFragment
import com.loufei.teambook.R
import com.loufei.teambook.databinding.FragAccountBinding

/**
 * Created by lvtengfei on 2019-12-26.
 */
class AccountFragment:BaseVMFragment<AccountViewModel,FragAccountBinding>() {
    override fun getLayoutResId() = R.layout.frag_account

    override fun providerVMClass() = AccountViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
    }
}