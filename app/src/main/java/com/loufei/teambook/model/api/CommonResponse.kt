package com.loufei.teambook.model.api

/**
 * Created by lvtengfei on 2019-11-14.
 */
data class CommonResponse<out T>(val errorCode:Int,val errorMsg:String,val success:Boolean,val data:T,val requestId:String)