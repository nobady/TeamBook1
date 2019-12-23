package com.loufei.teambook.model.api

import java.io.IOException
import com.loufei.base.core.Result
import kotlinx.coroutines.*

/**
 * Created by lvtengfei on 2019-11-14.
 */
open class BaseReposition {


    suspend fun <T:Any> safeApiCall(call:suspend() -> Result<T>, errorMessage:String = ""): Result<T> {
        return withContext(Dispatchers.IO){
            try {
                call()
            }catch (e:Exception){
                Result.Error(e)
            }
        }
    }

    suspend fun <T : Any> executeResponse(response:suspend() -> CommonResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
                                          errorBlock: (suspend CoroutineScope.() -> Unit)? = null): Result<T> {
        return coroutineScope {
            val data = async(Dispatchers.IO){
                response()
            }
            val await = data.await()
            if (await.errorCode != 0) {
                errorBlock?.let { it() }
                Result.Error(IOException(await.errorMsg))
            } else {
                successBlock?.let { it() }
                Result.Success(await.data)
            }
        }
    }
}