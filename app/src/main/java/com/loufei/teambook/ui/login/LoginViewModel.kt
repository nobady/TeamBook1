package com.loufei.teambook.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.loufei.base.ui.BaseViewModel

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginViewModel:BaseViewModel() {

    fun gotoPwd() {
        _uiState.value = LoginUiModel(false)
    }
    fun  goBackLogin(){
        _uiState.value = LoginUiModel(true)
    }

    fun startLogin(){

    }

    private var _uiState = MutableLiveData<LoginUiModel>()

    val uiState:LiveData<LoginUiModel>
    get() = _uiState

    data class LoginUiModel(var isShowLogin:Boolean = true)

    fun init(){
        _uiState.value = LoginUiModel()
    }
}