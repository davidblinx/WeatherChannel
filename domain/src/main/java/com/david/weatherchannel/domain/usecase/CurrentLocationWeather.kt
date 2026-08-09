package com.david.weatherchannel.domain.usecase

import com.david.weatherchannel.core.network.ApiResponse
import com.david.weatherchannel.domain.entity.weather.CoordinatesEntity

data class CurrentLocationWeather(
    val coordinates: CoordinatesEntity,
    val weather: ApiResponse<WeatherContent>,
)
