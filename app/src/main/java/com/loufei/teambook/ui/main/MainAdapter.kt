package com.loufei.teambook.ui.main

import com.loufei.base.ui.recyclerview.BaseBindingAdapter
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ItemBillDetailAdapterBinding
import com.loufei.teambook.model.bean.BillDetail

/**
 * Created by lvtengfei on 2019-12-19.
 */
class MainAdapter: BaseBindingAdapter<BillDetail, ItemBillDetailAdapterBinding>() {

    override fun initView(binding: ItemBillDetailAdapterBinding, data: BillDetail) {
        

    }

    override val layoutId: Int
        get() = R.layout.item_bill_detail_adapter


}