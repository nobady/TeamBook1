package com.loufei.teambook.ui.home

import com.loufei.base.ui.recyclerview.BaseBindingAdapter
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ItemBillDetailAdapterBinding
import com.loufei.teambook.model.bean.BillDetail

/**
 * Created by lvtengfei on 2019-12-27.
 */
class HomeAdapter : BaseBindingAdapter<BillDetail, ItemBillDetailAdapterBinding>() {

    override val layoutId: Int
        get() = R.layout.item_bill_detail_adapter

    override
    fun initView(binding: ItemBillDetailAdapterBinding, data: BillDetail) {

    }
}