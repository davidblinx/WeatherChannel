package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastRainDto
import com.david.weatherchannel.domain.entity.weather.ForecastRainEntity
import javax.inject.Inject

class ForecastRainMapper @Inject constructor() : Mapper<ForecastRainDto, ForecastRainEntity> {

    override fun map(from: ForecastRainDto): ForecastRainEntity = ForecastRainEntity(
        threeHour = from.threeHour ?: 0.0,
    )
}
