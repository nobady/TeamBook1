package com.loufei.teambook.ui.login.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loufei.base.core.Result
import com.loufei.base.ext.isPhoneNumber
import com.loufei.base.ext.logv
import com.loufei.base.ext.showLog
import com.loufei.base.ui.BaseViewModel
import com.loufei.teambook.R
import com.loufei.teambook.model.reposition.LoginReposition
import com.loufei.teambook.ui.login.LoginFromState
import kotlinx.coroutines.delay

/**
 * Created by lvtengfei on 2019-12-09.
 */
class RegisterViewModel : BaseViewModel() {

    private val reposition by lazy { LoginReposition() }

    private val _sendCodeText = MutableLiveData<String>()
    val sendCodeText: LiveData<String> = _sendCodeText

    private val _registerState = MutableLiveData<LoginFromState>()
    val registerState: LiveData<LoginFromState> = _registerState

    private val _registerResult = MutableLiveData<Result<Boolean>>()
    val registerResult:LiveData<Result<Boolean>> = _registerResult

    private val _sendCodeState = MutableLiveData<Boolean>()
    val sendCodeState:LiveData<Boolean> = _sendCodeState

    override fun initThing() {
        super.initThing()
        _sendCodeText.value = "发送验证码"
    }

    fun registerDataChange(phone: String, pwd: String) {
        _sendCodeState.value = true
        if (!phone.isPhoneNumber()) {
            _sendCodeState.value = false
            _registerState.value = LoginFromState(phoneError = R.string.input_phone_error)
        } else if (pwd.length < 6 || pwd.length > 12) {
            _registerState.value = LoginFromState(passwordError = R.string.input_pwd_error)
        } else {
            _registerState.value = LoginFromState(isDataValid = true)
        }
    }

    fun getVerifyCode(phone: String) {
        launch(tryBlock = {
            _registerResult.value = reposition.getVerifyCode(phone)
            for (i in 1..60){
                _sendCodeText.value = "${i}s后重试"
                _sendCodeState.value = false
                delay(1000)
            }
            _sendCodeState.value = true
            _sendCodeText.value = "发送验证码"
        })
    }


}