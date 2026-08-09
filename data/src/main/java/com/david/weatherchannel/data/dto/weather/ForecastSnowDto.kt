package com.david.weatherchannel.data.dto.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastSnowDto(
    @SerialName("3h") val threeHour: Double? = null,
)
