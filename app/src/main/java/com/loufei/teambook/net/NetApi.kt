package com.loufei.teambook.net

import com.loufei.teambook.model.api.CommonResponse
import com.loufei.teambook.model.bean.PersonDetail
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by lvtengfei on 2019-12-09.
 */
interface NetApi {

    @POST("/user/login")
    suspend fun login(@Body body: RequestBody):CommonResponse<PersonDetail>
    //获取验证码
    suspend fun getVerifyCode(@Body body: RequestBody):CommonResponse<Boolean>

    //注册
    suspend fun register(@Body body: RequestBody):CommonResponse<Boolean>
}