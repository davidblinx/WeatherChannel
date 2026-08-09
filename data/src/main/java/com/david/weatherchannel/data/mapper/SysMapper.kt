package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.SysDto
import com.david.weatherchannel.domain.entity.weather.SysEntity
import javax.inject.Inject

class SysMapper @Inject constructor() : Mapper<SysDto?, SysEntity> {

    override fun map(from: SysDto?): SysEntity = SysEntity(
        type = from?.type ?: 0,
        id = from?.id ?: 0,
        country = from?.country.orEmpty(),
        sunrise = from?.sunrise ?: 0L,
        sunset = from?.sunset ?: 0L,
    )
}
