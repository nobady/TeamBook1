package com.loufei.teambook.model.api

/**
 * Created by lvtengfei on 2019-11-14.
 */
data class CommonResponse<out T>(val code:Int,val errorMsg:String,val data:T)