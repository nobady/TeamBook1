package com.loufei.teambook.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loufei.base.ui.BaseViewModel

/**
 * Created by lvtengfei on 2019-12-12.
 */
class MainViewModel: BaseViewModel() {

    //记录当月消费总数
    private val _totalExpenses = MutableLiveData<String>()
    val totalExpensesValue:LiveData<String> = _totalExpenses

    private val _totalIncome = MutableLiveData<String>()
    val totalIncomeValue:LiveData<String> = _totalIncome

    private val _todayExpenses = MutableLiveData<String>()
    val todayExpense:LiveData<String> = _todayExpenses

    private val _todayIncome = MutableLiveData<String>()
    val todayIncome:LiveData<String> = _todayIncome

    override fun initThing() {
        super.initThing()
        _totalExpenses.value = "￥0"
        _totalIncome.value = "￥0"
        _todayExpenses.value = "￥0"
        _todayIncome.value = "￥0"
    }
}