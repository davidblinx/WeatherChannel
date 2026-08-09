package com.david.weatherchannel.core.ui.state

import androidx.compose.runtime.Stable

@Stable
data class UIStateHolder<T>(val uiState: UIState = UIState.Idle, val payload: T? = null)

fun <T> toIdle(): UIStateHolder<T> = UIStateHolder(uiState = UIState.Idle)

fun <T> toLoading(): UIStateHolder<T> = UIStateHolder(uiState = UIState.Loading)

inline fun <T, R> UIStateHolder<T>.mapSuccess(transform: (T) -> R): UIStateHolder<R> =
    UIStateHolder(uiState = uiState, payload = payload?.let(transform))
