package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.CoordinatesDto
import com.david.weatherchannel.domain.entity.weather.CoordinatesEntity
import javax.inject.Inject

class CoordinatesMapper @Inject constructor() : Mapper<CoordinatesDto?, CoordinatesEntity> {

    override fun map(from: CoordinatesDto?): CoordinatesEntity = CoordinatesEntity(
        longitude = from?.longitude ?: 0.0,
        latitude = from?.latitude ?: 0.0,
    )
}
