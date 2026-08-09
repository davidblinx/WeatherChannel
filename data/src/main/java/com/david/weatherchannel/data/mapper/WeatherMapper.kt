package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.ApiConfig
import com.david.weatherchannel.data.dto.weather.WeatherDto
import com.david.weatherchannel.domain.entity.weather.WeatherEntity
import javax.inject.Inject

class WeatherMapper @Inject constructor() : Mapper<WeatherDto, WeatherEntity> {

    override fun map(from: WeatherDto): WeatherEntity = WeatherEntity(
        id = from.id ?: 0,
        main = from.main.orEmpty(),
        description = from.description.orEmpty(),
        icon = from.icon?.let { iconCode -> "${ApiConfig.WEATHER_ICON_BASE_URL}/$iconCode.png" }.orEmpty(),
    )
}
