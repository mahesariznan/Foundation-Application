package com.iznan.domain.base

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val errorCode: Int?
) {

    companion object {
        fun <T> success(data: T?, message: String? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, message, null)
        }

        fun <T> error(errorCode: Int?, message: String?, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message, errorCode)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    inline fun <R> mapResource(transformer: (T?) -> R): Resource<R> {
        return when (status) {
            Status.SUCCESS -> success(transformer(data), message)
            Status.ERROR -> error(errorCode, message, transformer(data))
            Status.LOADING -> loading(transformer(data))
        }
    }
}
