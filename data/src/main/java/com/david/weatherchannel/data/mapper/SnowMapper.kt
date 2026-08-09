package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.SnowDto
import com.david.weatherchannel.domain.entity.weather.SnowEntity
import javax.inject.Inject

class SnowMapper @Inject constructor() : Mapper<SnowDto, SnowEntity> {

    override fun map(from: SnowDto): SnowEntity = SnowEntity(
        oneHour = from.oneHour ?: 0.0,
    )
}
