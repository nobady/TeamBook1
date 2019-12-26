package com.loufei.teambook.ui.login.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loufei.base.core.Result
import com.loufei.base.ext.isPhoneNumber
import com.loufei.base.ext.loge
import com.loufei.base.ui.BaseViewModel
import com.loufei.teambook.R
import com.loufei.teambook.model.bean.PersonDetail
import com.loufei.teambook.model.reposition.LoginReposition
import com.loufei.teambook.ui.login.LoginFromState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginViewModel:BaseViewModel() {

    private val _loginFrom = MutableLiveData<LoginFromState>()
    val loginFromState:LiveData<LoginFromState> = _loginFrom

    private val _loginResult = MutableLiveData<Result<PersonDetail>>()
    val loginResult:LiveData<Result<PersonDetail>> = _loginResult

    private val _loginSendCodeText = MutableLiveData<String>()
    private val _registerSendCodeText = MutableLiveData<String>()
    var loginSendCodeText: LiveData<String> = _loginSendCodeText
    var registerSendCodeText: LiveData<String> = _registerSendCodeText

    private val _loginSendCodeState = MutableLiveData<Boolean>()
    private val _registerSendCodeState = MutableLiveData<Boolean>()
    var loginSendCodeState:LiveData<Boolean> = _loginSendCodeState
    var registerSendCodeState:LiveData<Boolean> = _registerSendCodeState

    private val _loginText = MutableLiveData<String>()
    val loginBtnText:LiveData<String> = _loginText

    //记录当前是fragment的位置
    private val _whichFragment = MutableLiveData<Int>()
    val whichFragmentPos:LiveData<Int> = _whichFragment

    private val _tipText = MutableLiveData<String>()
    val tipTitleText:LiveData<String> = _tipText

    private val mReposition by lazy { LoginReposition() }

    init {
        _loginSendCodeText.value = "获取验证码"
        _registerSendCodeText.value = "获取验证码"
    }

    fun loginDataChange(phone:String){
        val sendBtnState =
            if (_whichFragment.value == 0) _loginSendCodeState else _registerSendCodeState
        sendBtnState.value = true
        if (!phone.isPhoneNumber()){
            sendBtnState.value = false
            _loginFrom.value =
                LoginFromState(phoneError = R.string.input_phone_error)
        }else{
            _loginFrom.value = LoginFromState(isDataValid = true)
        }
    }

    fun login(phone: String,password: String){
        launch(tryBlock = {
            _loginResult.value = mReposition.login(phone,password)
        })
    }

    fun changeFragment(position: Int) {
        _whichFragment.value = position
        _loginText.value = if (position==0) "登录" else "立即注册"
        _tipText.value = if (position==0) "请输入账号密码" else "欢迎加入，招财宝"
    }

    fun getVerifyCode(phone: String) {

        launch(tryBlock = {
//            _registerResult.value = reposition.getVerifyCode(phone)
            val liveData =
                if (_whichFragment.value == 0) _loginSendCodeText else _registerSendCodeText
            val sendBtnState =
                if (_whichFragment.value == 0) _loginSendCodeState else _registerSendCodeState
            for (i in 1..60){
                liveData.value = "${i}s后重新获取"
                sendBtnState.value = false
                delay(1000)
            }
            sendBtnState.value = true
            liveData.value = "获取验证码"
        })
    }
}