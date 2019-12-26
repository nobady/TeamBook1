package com.loufei.teambook.ui.analysis

import com.loufei.base.ui.fragment.BaseVMFragment
import com.loufei.teambook.R
import com.loufei.teambook.databinding.FragAnalysisBinding

/**
 * Created by lvtengfei on 2019-12-26.
 */
class AnalysisFragment:BaseVMFragment<AnalysisViewModel,FragAnalysisBinding>() {
    override fun getLayoutResId()  = R.layout.frag_analysis

    override fun providerVMClass() = AnalysisViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
    }
}