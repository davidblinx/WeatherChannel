package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RainDto(
    @SerialName("1h") val oneHour: Double? = null,
)
