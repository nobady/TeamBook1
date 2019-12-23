package com.loufei.teambook.ui.login

/**
 * 参考系统生成的登录页面逻辑
 * 号码无效，密码长度过短，登录按钮是否可以点击都是根据这里来进行判断
 * Created by lvtengfei on 2019-12-06.
 */
data class LoginFromState(
    val phoneError:Int? = null,
    val passwordError:Int? = null,
    val isDataValid:Boolean = false
)