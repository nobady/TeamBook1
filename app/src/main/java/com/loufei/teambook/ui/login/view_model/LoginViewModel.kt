package com.loufei.teambook.ui.login.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loufei.base.core.Result
import com.loufei.base.ext.isPhoneNumber
import com.loufei.base.ui.BaseViewModel
import com.loufei.teambook.R
import com.loufei.teambook.model.bean.PersonDetail
import com.loufei.teambook.model.reposition.LoginReposition
import com.loufei.teambook.ui.login.LoginFromState
import kotlinx.coroutines.coroutineScope

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginViewModel:BaseViewModel() {

    private val _loginFrom = MutableLiveData<LoginFromState>()
    val loginFromState:LiveData<LoginFromState> = _loginFrom

    private val _loginResult = MutableLiveData<Result<PersonDetail>>()
    val loginResult:LiveData<Result<PersonDetail>> = _loginResult

    private val mReposition by lazy { LoginReposition() }


    fun loginDataChange(phone:String,password:String){
        if (!phone.isPhoneNumber()){
            _loginFrom.value =
                LoginFromState(phoneError = R.string.input_phone_error)
        }else if(password.length<6||password.length>12){
            _loginFrom.value =
                LoginFromState(passwordError = R.string.input_pwd_error)
        }else{
            _loginFrom.value = LoginFromState(isDataValid = true)
        }
    }

    fun login(phone: String,password: String){
        launch(tryBlock = {
            _loginResult.value = mReposition.login(phone,password)
        })

    }
}