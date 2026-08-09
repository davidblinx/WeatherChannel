package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastCityDto(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("coord") val coordinates: CoordinatesDto? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("population") val population: Int? = null,
    @SerialName("timezone") val timezone: Int? = null,
    @SerialName("sunrise") val sunrise: Long? = null,
    @SerialName("sunset") val sunset: Long? = null,
)
