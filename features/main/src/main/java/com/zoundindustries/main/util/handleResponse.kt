package com.zoundindustries.main.util

import retrofit2.HttpException

suspend fun <T : Any> handleResponse(requestFunc: suspend () -> T): Result<T> {
    return try {
        Result.success(requestFunc.invoke())
    } catch (e: HttpException) {
        when {
            e.code() == 400 -> Result.failure(Throwable(e.message()))
            else -> Result.failure(e)
        }
    }
}