package com.loufei.teambook.ui.login

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.loufei.base.core.Result
import com.loufei.base.ext.contentView
import com.loufei.base.ext.startKtxActivity
import com.loufei.base.listener.textWatcher
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityLoginBinding
import com.loufei.teambook.ui.login.view_model.LoginViewModel
import com.loufei.teambook.ui.main.MainActivity

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginActivity : BaseVMActivity<LoginViewModel>() {

    private val binding by contentView<LoginActivity, ActivityLoginBinding>(R.layout.activity_login)

    override fun providerVMClass() = LoginViewModel::class.java

    override fun getLayoutResId() = R.layout.activity_login

    override fun initView() {

        binding.lifecycleOwner = this
        binding.loginModel = mViewModel

        val phoneEt = findViewById<EditText>(R.id.et_login_phone)
        val pwdEt = findViewById<EditText>(R.id.et_login_pwd)
        val loginBtn = findViewById<Button>(R.id.btn_login_sign_in)


        mViewModel.loginFromState.observe(this, Observer { loginFromState ->
            loginFromState.phoneError?.let { phoneEt.error = getString(it) }
            loginFromState.passwordError?.let { pwdEt.error = getString(it) }
        })

        mViewModel.loginResult.observe(this, Observer {
            it?.takeIf { it is Result.Success }?.let { /*登录成功*/
                startKtxActivity<MainActivity>()
                finish()
            }
            it?.takeIf { it is Result.Error }?.let { /*登录失败*/ }
        })

        phoneEt.textWatcher {
            afterTextChanged {
                mViewModel.loginDataChange(
                    phoneEt.text.toString(),
                    pwdEt.text.toString()
                )
            }
        }

        pwdEt.textWatcher {
            afterTextChanged {
                mViewModel.loginDataChange(phoneEt.text.toString(), pwdEt.text.toString())
            }
        }

        loginBtn.setOnClickListener { mViewModel.login(phoneEt.text.toString(), pwdEt.text.toString()) }
    }


    override fun initData() {
    }

    fun toRegister(view: View) {
        startKtxActivity<RegisterActivity>()
    }


}