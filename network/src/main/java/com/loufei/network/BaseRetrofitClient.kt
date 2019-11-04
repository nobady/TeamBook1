package com.loufei.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by lvtengfei on 2019-10-23.
 */
abstract class BaseRetrofitClient {

    companion object{
        private const val TIME_OUT=5
    }

    private val client:OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG){
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }else{
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            }
            builder.addInterceptor(loggingInterceptor)
                    .connectTimeout(TIME_OUT.toLong(),TimeUnit.SECONDS)

            handleBuilder(builder)
            return builder.build()
        }

    abstract fun handleBuilder(builder: OkHttpClient.Builder)

    fun <S> getService(serviceClass: Class<S>,baseUrl:String):S{
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build().create(serviceClass)
    }
}