package com.david.weatherchannel.presentation.search.model

import com.david.weatherchannel.core.mvi.action.Action

sealed interface SearchAction : Action {
    data class OnQueryChange(val query: String) : SearchAction
    data object OnSearchSubmit : SearchAction
    data object OnRetryClick : SearchAction
    data class OnCitySelected(val location: LocationResultUiModel) : SearchAction
}
