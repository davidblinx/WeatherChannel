package com.david.weatherchannel.data.dto.geocoding

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeocodingResultDto(
    @SerialName("name") val name: String? = null,
    @SerialName("local_names") val localNames: Map<String, String>? = null,
    @SerialName("lat") val latitude: Double? = null,
    @SerialName("lon") val longitude: Double? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("state") val state: String? = null,
)
