package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesDto(
    @SerialName("lon") val longitude: Double? = null,
    @SerialName("lat") val latitude: Double? = null,
)
