package com.loufei.teambook.model.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException
import com.loufei.base.core.Result

/**
 * Created by lvtengfei on 2019-11-14.
 */
open class BaseReposition {


    suspend fun <T:Any> apiCall(call:suspend() -> CommonResponse<T>):CommonResponse<T>{
        return call.invoke()
    }

    suspend fun <T:Any> safeApiCall(call:suspend() -> Result<T>, errorMessage:String): Result<T> {
        return try {
            call()
        }catch (e:Exception){
            Result.Error(e)
        }
    }

    suspend fun <T : Any> executeResponse(response: CommonResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
                                          errorBlock: (suspend CoroutineScope.() -> Unit)? = null): Result<T> {
        return coroutineScope {
            if (response.code != 0) {
                errorBlock?.let { it() }
                Result.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                Result.Success(response.data)
            }
        }
    }
}