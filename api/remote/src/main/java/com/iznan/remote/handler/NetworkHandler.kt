package com.iznan.remote.handler

import com.google.gson.Gson
import com.iznan.domain.base.Resource
import com.iznan.model.base.BaseResponseData
import com.iznan.model.responsedata.ErrorResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.net.SocketTimeoutException

fun <ResponseType : BaseResponseData, ResultType> networkHandling(
    callApi: suspend () -> Response<ResponseType>,
    processResult: (response: ResponseType?) -> ResultType?,
    processMessageResult: (response: ResponseType?) -> String? = { it?.message }
): Flow<Resource<ResultType>> = flow {
    emit(Resource.loading())
    try {
        callApi.invoke().run {
            when {
                isSuccessful -> {
                    val response = body()
                    emit(Resource.success(processResult(response), processMessageResult(response)))
                }

                else -> {
                    val errorBody = errorBody()?.let {
                        Gson().fromJson(it.stringSuspending(), ErrorResponseData::class.java)
                    }
                    emit(Resource.error(errorCode = code(), message = errorBody?.message))
                }
            }
        }
    } catch (ex: SocketTimeoutException) {
        emit(Resource.error(errorCode = 504, message = ex.message ?: ex.toString()))
    } catch (e: Exception) {
        emit(Resource.error(errorCode = 0, message = e.message ?: e.toString()))
    }
}.flowOn(Dispatchers.IO)

suspend fun ResponseBody.stringSuspending(): String =
    withContext(Dispatchers.IO) { runCatching(::string).getOrThrow() }