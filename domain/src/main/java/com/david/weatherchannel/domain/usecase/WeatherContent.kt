package com.david.weatherchannel.domain.usecase

import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity
import com.david.weatherchannel.domain.entity.weather.ForecastEntity

data class WeatherContent(
    val currentWeather: CurrentWeatherEntity,
    val forecast: ForecastEntity?,
)
