package com.david.weatherchannel.domain.entity.geocoding

data class GeocodingResultEntity(
    val name: String,
    val localNames: Map<String, String>?,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val state: String?,
)
