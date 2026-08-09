package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastSysDto(
    @SerialName("pod") val pod: String? = null,
)
