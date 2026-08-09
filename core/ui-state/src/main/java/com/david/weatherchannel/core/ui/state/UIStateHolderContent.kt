package com.david.weatherchannel.core.ui.state

import androidx.compose.runtime.Composable

@Composable
fun <T> UIStateHolder<T>.RenderContent(
    idleContent: @Composable () -> Unit = {},
    loadingContent: @Composable () -> Unit,
    errorContent: @Composable (String?) -> Unit,
    successContent: @Composable (T) -> Unit,
) {
    when (val currentState = uiState) {
        UIState.Idle -> idleContent()
        UIState.Loading -> loadingContent()
        is UIState.Error -> errorContent(currentState.message)
        UIState.Success -> {
            val currentPayload = payload
            if (currentPayload != null) successContent(currentPayload)
        }
    }
}
