package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherResponseDto(
    @SerialName("coord") val coordinates: CoordinatesDto? = null,
    @SerialName("weather") val weather: List<WeatherDto>? = null,
    @SerialName("base") val base: String? = null,
    @SerialName("main") val main: MainWeatherDto? = null,
    @SerialName("visibility") val visibility: Int? = null,
    @SerialName("wind") val wind: WindDto? = null,
    @SerialName("rain") val rain: RainDto? = null,
    @SerialName("snow") val snow: SnowDto? = null,
    @SerialName("clouds") val clouds: CloudsDto? = null,
    @SerialName("dt") val dt: Long? = null,
    @SerialName("sys") val sys: SysDto? = null,
    @SerialName("timezone") val timezone: Int? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("cod") val cod: Int? = null,
)
