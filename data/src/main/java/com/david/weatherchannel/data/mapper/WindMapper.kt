package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.WindDto
import com.david.weatherchannel.domain.entity.weather.WindEntity
import javax.inject.Inject

class WindMapper @Inject constructor() : Mapper<WindDto?, WindEntity> {

    override fun map(from: WindDto?): WindEntity = WindEntity(
        speed = from?.speed ?: 0.0,
        deg = from?.deg ?: 0,
        gust = from?.gust ?: 0.0,
    )
}
