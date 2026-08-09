package com.david.weatherchannel.core.ui.state

import com.david.weatherchannel.core.network.ApiResponse

fun <T> ApiResponse<T>.asUIStateHolder(): UIStateHolder<T> = when (this) {
    is ApiResponse.Success -> UIStateHolder(uiState = UIState.Success, payload = data)
    is ApiResponse.Failure.Error -> UIStateHolder(uiState = UIState.Error(message = body))
    is ApiResponse.Failure.Exception -> UIStateHolder(uiState = UIState.Error(message = throwable.message))
}
