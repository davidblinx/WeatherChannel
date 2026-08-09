package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.geocoding.GeocodingResultDto
import com.david.weatherchannel.domain.entity.geocoding.GeocodingResultEntity
import javax.inject.Inject

class GeocodingResultMapper @Inject constructor() : Mapper<GeocodingResultDto, GeocodingResultEntity> {

    override fun map(from: GeocodingResultDto): GeocodingResultEntity = GeocodingResultEntity(
        name = from.name.orEmpty(),
        localNames = from.localNames,
        latitude = from.latitude ?: 0.0,
        longitude = from.longitude ?: 0.0,
        country = from.country.orEmpty(),
        state = from.state,
    )
}
