package com.david.weatherchannel.data.repository

import com.david.weatherchannel.core.network.ApiResponse
import com.david.weatherchannel.core.network.mapSuccess
import com.david.weatherchannel.data.mapper.CurrentWeatherMapper
import com.david.weatherchannel.data.mapper.GeocodingResultMapper
import com.david.weatherchannel.data.service.WeatherService
import com.david.weatherchannel.domain.entity.geocoding.GeocodingResultEntity
import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity
import com.david.weatherchannel.domain.repository.WeatherRepository
import javax.inject.Inject

internal class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val geocodingResultMapper: GeocodingResultMapper,
) : WeatherRepository {

    override suspend fun getWeatherByCoordinates(
        latitude: Double,
        longitude: Double,
        units: String?,
        lang: String?,
    ): ApiResponse<CurrentWeatherEntity> =
        weatherService.getWeatherByCoordinates(latitude, longitude, units, lang)
            .mapSuccess(currentWeatherMapper::map)

    override suspend fun getCoordinatesByLocationName(
        query: String,
        limit: Int?,
    ): ApiResponse<List<GeocodingResultEntity>> =
        weatherService.getCoordinatesByLocationName(query, limit)
            .mapSuccess { map(geocodingResultMapper::map) }
}
