package com.loufei.teambook.ui.login

import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import com.loufei.base.ext.contentView
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_pwd_login.*
import kotlinx.android.synthetic.main.layout_username_login.*

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginActivity:BaseVMActivity<LoginViewModel>() {

    private val binding by contentView<LoginActivity,ActivityLoginBinding>(R.layout.activity_login)

    override fun providerVMClass() = LoginViewModel::class.java

    override fun getLayoutResId() = R.layout.activity_login

    override fun initView() {

        binding.lifecycleOwner = this
        binding.mLoginViewModel = mViewModel

        mViewModel.init()

        mbtn_next_sign_in_username.setOnClickListener {
            mViewModel.gotoPwd()
            hintAnimation()
        }

        fab_back.setOnClickListener {
            mViewModel.goBackLogin()
            showAnimation()
        }

    }

    private fun showAnimation(){
        val animation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            1f, Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f)
        animation.duration = 1000
        layout_username.startAnimation(animation)
    }

    private fun hintAnimation(){
        val animation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            0f, Animation.RELATIVE_TO_SELF, -1.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f)
        animation.duration = 1000
        layout_pwd.startAnimation(animation)
    }


    override fun initData() {
    }


}