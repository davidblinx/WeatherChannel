package com.david.weatherchannel.presentation.weather.details.model

import androidx.annotation.StringRes

data class WeatherDetailItemUiModel(
    @StringRes val labelRes: Int,
    val value: String,
)
