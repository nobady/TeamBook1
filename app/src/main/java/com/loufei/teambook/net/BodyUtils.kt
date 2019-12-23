package com.loufei.teambook.net

import androidx.collection.ArrayMap
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

/**
 * 将参数转换成RequestBody
 * Created by lvtengfei on 2019-12-09.
 */
object BodyUtils {

    const val TYPE = "application/json"

    fun toLoginBody(phone: String, pwd: String): RequestBody {
        val jsonObject = JSONObject()
        jsonObject.put("loginName",phone)
        jsonObject.put("password",pwd)
        return RequestBody.create(MediaType.get(TYPE),jsonObject.toString())
    }

    fun toVerifyCodeBody(phone: String):RequestBody{
        val jsonObject = JSONObject()
        jsonObject.put("phone",phone)
        return RequestBody.create(MediaType.get(TYPE),jsonObject.toString())
    }
}