package com.david.weatherchannel.presentation.weather.details.model

import com.david.weatherchannel.core.mvi.action.Action

sealed interface WeatherDetailsAction : Action {
    data object OnRetryClick : WeatherDetailsAction
    data object OnSearchClick : WeatherDetailsAction
    data class OnLocationPermissionResult(val granted: Boolean) : WeatherDetailsAction
}
