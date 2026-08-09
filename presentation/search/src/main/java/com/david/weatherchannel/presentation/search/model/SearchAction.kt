package com.david.weatherchannel.presentation.search.model

import com.david.weatherchannel.core.mvi.action.Action

sealed interface SearchAction : Action {
    data class OnCitySelected(val lat: Double, val lon: Double) : SearchAction
}
