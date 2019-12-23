package com.loufei.teambook.model.reposition

import com.loufei.base.core.Result
import com.loufei.teambook.model.api.BaseReposition
import com.loufei.teambook.model.bean.PersonDetail
import com.loufei.teambook.net.BodyUtils
import com.loufei.teambook.net.HttpRequest

/**
 * Created by lvtengfei on 2019-11-14.
 */
class LoginReposition : BaseReposition() {

    suspend fun login(phone: String, pwd: String): Result<PersonDetail> {

//        val result = executeResponse(response = {
//            HttpRequest.getService().login(BodyUtils.toLoginBody(phone, pwd))
//        }
//        )
//        if (result is Result.Success) {
//            //将用户保存
//        }
        return Result.Success(PersonDetail("1"))
    }

    suspend fun getVerifyCode(phone: String): Result<Boolean> {
        return executeResponse(response = {
            HttpRequest.getService().getVerifyCode(BodyUtils.toVerifyCodeBody(phone))
        }
        )
    }
}