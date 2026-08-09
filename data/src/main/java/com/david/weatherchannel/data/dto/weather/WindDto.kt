package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    @SerialName("speed") val speed: Double? = null,
    @SerialName("deg") val deg: Int? = null,
    @SerialName("gust") val gust: Double? = null,
)
