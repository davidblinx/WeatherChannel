package com.david.weatherchannel.presentation.weather.details.model

data class ForecastDayUiModel(
    val dayLabel: String,
    val iconUrl: String,
    val highTemp: String,
    val lowTemp: String,
    val precipitationChance: String,
)
