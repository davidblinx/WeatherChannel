package com.david.weatherchannel.data.repository

import com.david.weatherchannel.core.location.LocationClient
import com.david.weatherchannel.domain.entity.weather.CoordinatesEntity
import com.david.weatherchannel.domain.repository.LocationRepository
import javax.inject.Inject

internal class LocationRepositoryImpl @Inject constructor(
    private val locationClient: LocationClient,
) : LocationRepository {

    override suspend fun getCurrentLocation(): CoordinatesEntity? =
        locationClient.getCurrentLocation()?.let { location ->
            CoordinatesEntity(latitude = location.latitude, longitude = location.longitude)
        }
}
