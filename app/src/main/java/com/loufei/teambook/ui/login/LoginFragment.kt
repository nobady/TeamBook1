package com.loufei.teambook.ui.login

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.loufei.base.core.Result
import com.loufei.base.ext.contentView
import com.loufei.base.ext.loge
import com.loufei.base.ext.startKtxActivity
import com.loufei.base.listener.textWatcher
import com.loufei.base.ui.fragment.BaseVMFragment
import com.loufei.teambook.R
import com.loufei.teambook.databinding.FragLoginBinding
import com.loufei.teambook.ui.login.view_model.LoginViewModel
import com.loufei.teambook.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Created by lvtengfei on 2019-12-24.
 */
class LoginFragment : BaseVMFragment<LoginViewModel, FragLoginBinding>() {

    override fun getLayoutResId() = R.layout.frag_login

    override fun providerVMClass() = LoginViewModel::class.java

    override fun initView() {
        binding?.model = mViewModel
    }

    override fun initData() {
        mViewModel.loginFromState.observe(this, Observer { loginFromState ->
            loginFromState.phoneError?.let {
                binding?.etLoginPhone?.error = getString(it)
                "输入错误".loge()
            }
        })
        binding?.etLoginPhone?.textWatcher {
            afterTextChanged {
                it?.let { mViewModel.loginDataChange(it.toString()) }
            }
        }
        binding?.btnLoginSendCode?.setOnClickListener {
            mViewModel.getVerifyCode(binding?.etLoginPhone?.text.toString())
        }
        binding?.btnRegisterSendCode?.setOnClickListener {
            mViewModel.getVerifyCode(binding?.etLoginPhone?.text.toString())
        }

        binding?.tvLogin?.setOnClickListener {
            mViewModel.login(binding?.etLoginPhone?.text.toString(),"")
        }

        mViewModel.loginResult.observe(this, Observer {
            it?.takeIf { it is Result.Success }?.let { /*登录成功*/
                startKtxActivity<MainActivity>()
                activity?.finish()
            }
            it?.takeIf { it is Result.Error }?.let { /*登录失败*/ }
        })
    }

}