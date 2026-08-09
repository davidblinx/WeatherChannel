package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastSysDto
import com.david.weatherchannel.domain.entity.weather.ForecastSysEntity
import javax.inject.Inject

class ForecastSysMapper @Inject constructor() : Mapper<ForecastSysDto?, ForecastSysEntity> {

    override fun map(from: ForecastSysDto?): ForecastSysEntity = ForecastSysEntity(
        pod = from?.pod.orEmpty(),
    )
}
