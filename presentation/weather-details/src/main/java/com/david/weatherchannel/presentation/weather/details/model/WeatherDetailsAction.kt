package com.david.weatherchannel.presentation.weather.details.model

import com.david.weatherchannel.core.mvi.action.Action

sealed interface WeatherDetailsAction : Action {
    data object OnSearchClick : WeatherDetailsAction
}
