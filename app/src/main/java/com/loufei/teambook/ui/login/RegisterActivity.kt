package com.loufei.teambook.ui.login

import android.view.View
import androidx.lifecycle.Observer
import com.loufei.base.core.Result
import com.loufei.base.ext.contentView
import com.loufei.base.listener.textWatcher
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityRegisterBinding
import com.loufei.teambook.ui.login.view_model.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.title_layout.*

/**
 * Created by lvtengfei on 2019-12-09.
 */
class RegisterActivity : BaseVMActivity<RegisterViewModel>() {

    private val binding by contentView<RegisterActivity, ActivityRegisterBinding>(R.layout.activity_register)

    override fun getLayoutResId() = R.layout.activity_register

    override fun providerVMClass() = RegisterViewModel::class.java

    override fun initView() {
        binding.lifecycleOwner = this
        binding.registerModel = mViewModel

        mViewModel.registerState.observe(this, Observer { fromState ->
            fromState.phoneError?.let { et_register_phone.error = getString(it) }
            fromState.passwordError?.let { et_register_input_pwd.error = getString(it) }
        })

        mViewModel.registerResult.observe(this, Observer {
            it?.takeIf { it is Result.Success }?.apply { /*注册成功*/ }
            it?.takeUnless { it is Result.Error }?.apply { /*注册失败*/ }
        })

        mToolbar.title = getString(R.string.register)


        et_register_phone.textWatcher {
            afterTextChanged {
                mViewModel.registerDataChange(
                    et_register_phone.text.toString(),
                    et_register_input_pwd.text.toString()
                )
            }
        }

        et_register_input_pwd.textWatcher {
            afterTextChanged {
                mViewModel.registerDataChange(
                    et_register_phone.text.toString(),
                    et_register_input_pwd.text.toString()
                )
            }
        }

    }

    override fun initData() {
    }

    fun sendVerifyCode(view: View) {
        mViewModel.getVerifyCode(et_register_phone.text.toString())
    }
}