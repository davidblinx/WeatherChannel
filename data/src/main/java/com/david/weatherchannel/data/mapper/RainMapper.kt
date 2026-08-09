package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.RainDto
import com.david.weatherchannel.domain.entity.weather.RainEntity
import javax.inject.Inject

class RainMapper @Inject constructor() : Mapper<RainDto, RainEntity> {

    override fun map(from: RainDto): RainEntity = RainEntity(
        oneHour = from.oneHour ?: 0.0,
    )
}
