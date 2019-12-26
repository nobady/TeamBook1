package com.loufei.teambook.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loufei.base.ui.BaseViewModel

/**
 * Created by lvtengfei on 2019-12-26.
 */
class HomeViewModel: BaseViewModel() {
    //月支出
    private val _expenseMonthValue = MutableLiveData<String>()
    val expenseMonthValue:LiveData<String> = _expenseMonthValue
    //收入
    private val _incomeValue = MutableLiveData<String>()
    val incomeValue:LiveData<String> = _incomeValue
    //余额
    private val _surplusValue = MutableLiveData<String>()
    val surplusValue:LiveData<String> = _surplusValue
    //当前账本
    private val _currentBillBook = MutableLiveData<String>()
    val currentBillBook:LiveData<String> = _currentBillBook

    init {
        _expenseMonthValue.value = "￥30003"
        _incomeValue.value = "￥100"
        _surplusValue.value = "￥20"
        _currentBillBook.value = "日常账本"
    }
}