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

@Suppress("UNCHECKED_CAST")
inline fun <reified T, reified V> ApiResponse<T>.mapSuccess(
    crossinline transformer: T.() -> V,
): ApiResponse<V> = if (this is ApiResponse.Success<T>) {
    ApiResponse.Success(data = transformer(data))
} else {
    this as ApiResponse<V>
}
