package com.loufei.teambook.net

import com.loufei.network.BaseRetrofitClient
import okhttp3.OkHttpClient

/**
 * Created by lvtengfei on 2019-12-09.
 */
object HttpRequest : BaseRetrofitClient() {

    const val BASE_URL = ""

    override fun handleBuilder(builder: OkHttpClient.Builder) {
    }

    fun getService() = super.getService(NetApi::class.java, BASE_URL)

}