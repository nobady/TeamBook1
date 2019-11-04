package com.loufei.teambook.ui.login

import android.Manifest
import androidx.databinding.DataBindingUtil
import com.loufei.base.ext.contentView
import com.loufei.base.ext.toast
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.permission.PermissionCanceled
import com.loufei.permission.PermissionDenied
import com.loufei.permission.Permissions
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.title_layout.*

/**
 * Created by lvtengfei on 2019-10-23.
 */
class LoginActivity:BaseVMActivity<LoginViewModel>() {

    private val binding by contentView<LoginActivity,ActivityLoginBinding>(R.layout.activity_login)

    override fun providerVMClass(): Class<LoginViewModel>? {
        return LoginViewModel::class.java
    }

    override fun getLayoutResId() = R.layout.activity_login

    override fun initView() {
        mToolbar.title = "登录"

        binding.viewModel = mViewModel
        binding.aivAppIcon.setOnClickListener { test() }
    }

    override fun initData() {
    }

    @Permissions(permissions = [Manifest.permission.ACCESS_FINE_LOCATION])
    fun test(){
        toast("权限申请")
    }
    @PermissionDenied
    fun denied(){
        toast("权限拒绝")
    }
    @PermissionCanceled
    fun cancel(){
        toast("权限取消")
    }
}