package com.david.weatherchannel.core.network

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get

suspend inline fun <reified T> HttpClient.getApiResponse(
    urlString: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {},
): ApiResponse<T> = apiResponseOf { get(urlString) { block() } }
