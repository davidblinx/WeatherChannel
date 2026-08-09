package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponseDto(
    @SerialName("cod") val cod: String? = null,
    @SerialName("message") val message: Int? = null,
    @SerialName("cnt") val cnt: Int? = null,
    @SerialName("list") val list: List<ForecastItemDto>? = null,
    @SerialName("city") val city: ForecastCityDto? = null,
)
