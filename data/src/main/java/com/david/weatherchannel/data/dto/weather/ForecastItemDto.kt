package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastItemDto(
    @SerialName("dt") val dt: Long? = null,
    @SerialName("main") val main: MainWeatherDto? = null,
    @SerialName("weather") val weather: List<WeatherDto>? = null,
    @SerialName("clouds") val clouds: CloudsDto? = null,
    @SerialName("wind") val wind: WindDto? = null,
    @SerialName("visibility") val visibility: Int? = null,
    @SerialName("pop") val pop: Double? = null,
    @SerialName("rain") val rain: ForecastRainDto? = null,
    @SerialName("snow") val snow: ForecastSnowDto? = null,
    @SerialName("sys") val sys: ForecastSysDto? = null,
    @SerialName("dt_txt") val dtText: String? = null,
)
