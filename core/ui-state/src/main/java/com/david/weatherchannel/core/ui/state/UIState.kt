package com.david.weatherchannel.core.ui.state

import androidx.compose.runtime.Stable

@Stable
sealed interface UIState {
    data object Loading : UIState
    data object Success : UIState
    data class Error(val message: String?) : UIState
}
