package com.david.weatherchannel.domain.repository

import com.david.weatherchannel.domain.entity.weather.CoordinatesEntity

interface LocationRepository {

    suspend fun getCurrentLocation(): CoordinatesEntity?
}
