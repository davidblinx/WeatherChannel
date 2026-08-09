package com.david.weatherchannel.core.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CancellationException

suspend inline fun <reified T> apiResponseOf(
    crossinline networkResponse: suspend () -> HttpResponse,
): ApiResponse<T> = try {
    val response = networkResponse()
    if (response.status.value in 200..299) {
        ApiResponse.Success(data = response.body() ?: Unit as T)
    } else {
        ApiResponse.Failure.Error(
            statusCode = response.status.value,
            body = response.bodyAsText(),
        )
    }
} catch (exception: CancellationException) {
    throw exception
} catch (exception: Exception) {
    ApiResponse.Failure.Exception(exception)
}
