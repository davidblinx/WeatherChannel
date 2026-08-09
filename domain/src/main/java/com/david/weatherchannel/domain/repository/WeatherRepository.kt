package com.david.weatherchannel.domain.repository

import com.david.weatherchannel.core.network.ApiResponse
import com.david.weatherchannel.domain.entity.geocoding.GeocodingResultEntity
import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity

interface WeatherRepository {

    suspend fun getWeatherByCoordinates(
        latitude: Double,
        longitude: Double,
        units: String? = null,
        lang: String? = null,
    ): ApiResponse<CurrentWeatherEntity>

    suspend fun getCoordinatesByLocationName(
        query: String,
        limit: Int? = null,
    ): ApiResponse<List<GeocodingResultEntity>>
}
