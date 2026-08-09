package com.david.weatherchannel.presentation.weather.details.model

import kotlinx.collections.immutable.ImmutableList

data class WeatherDetailsContentUiModel(
    val header: CurrentWeatherHeaderUiModel,
    val details: ImmutableList<WeatherDetailItemUiModel>,
    val forecast: ImmutableList<ForecastDayUiModel>,
)
