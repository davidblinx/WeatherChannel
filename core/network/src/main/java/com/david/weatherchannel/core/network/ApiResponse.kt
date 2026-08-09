package com.david.weatherchannel.core.network

sealed interface ApiResponse<out T> {

    data class Success<T>(val data: T) : ApiResponse<T>

    sealed interface Failure<T> : ApiResponse<T> {

        data class Error(val statusCode: Int, val body: String?) : Failure<Nothing>

        data class Exception(val throwable: Throwable) : Failure<Nothing>
    }
}
