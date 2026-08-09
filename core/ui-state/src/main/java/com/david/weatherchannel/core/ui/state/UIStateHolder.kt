package com.david.weatherchannel.core.ui.state

import androidx.compose.runtime.Stable

@Stable
data class UIStateHolder<T>(val uiState: UIState = UIState.Loading, val payload: T? = null)

fun <T> toLoading(): UIStateHolder<T> = UIStateHolder(uiState = UIState.Loading)
