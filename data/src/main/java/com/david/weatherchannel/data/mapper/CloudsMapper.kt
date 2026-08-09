package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.CloudsDto
import com.david.weatherchannel.domain.entity.weather.CloudsEntity
import javax.inject.Inject

class CloudsMapper @Inject constructor() : Mapper<CloudsDto?, CloudsEntity> {

    override fun map(from: CloudsDto?): CloudsEntity = CloudsEntity(
        all = from?.all ?: 0,
    )
}
