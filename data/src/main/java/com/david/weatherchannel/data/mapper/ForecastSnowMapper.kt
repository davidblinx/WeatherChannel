package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastSnowDto
import com.david.weatherchannel.domain.entity.weather.ForecastSnowEntity
import javax.inject.Inject

class ForecastSnowMapper @Inject constructor() : Mapper<ForecastSnowDto, ForecastSnowEntity> {

    override fun map(from: ForecastSnowDto): ForecastSnowEntity = ForecastSnowEntity(
        threeHour = from.threeHour ?: 0.0,
    )
}
