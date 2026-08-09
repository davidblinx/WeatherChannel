package com.david.weatherchannel.presentation.weather.details.model

data class CurrentWeatherHeaderUiModel(
    val locationName: String,
    val condition: String,
    val temperature: String,
    val feelsLike: String,
    val highLow: String,
    val iconUrl: String,
)
