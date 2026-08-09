package com.david.weatherchannel.core.network

inline fun <T> ApiResponse<T>.onSuccess(action: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T> ApiResponse<T>.onError(action: (ApiResponse.Failure.Error) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Failure.Error) action(this)
    return this
}

inline fun <T> ApiResponse<T>.onException(action: (Throwable) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Failure.Exception) action(throwable)
    return this
}

fun <T> ApiResponse<T>.getOrNull(): T? = when (this) {
    is ApiResponse.Success -> data
    is ApiResponse.Failure -> null
}
