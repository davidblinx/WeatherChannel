package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastResponseDto
import com.david.weatherchannel.domain.entity.weather.ForecastEntity
import javax.inject.Inject

class ForecastMapper @Inject constructor(
    private val forecastItemMapper: ForecastItemMapper,
    private val forecastCityMapper: ForecastCityMapper,
) : Mapper<ForecastResponseDto, ForecastEntity> {

    override fun map(from: ForecastResponseDto): ForecastEntity = ForecastEntity(
        cod = from.cod.orEmpty(),
        message = from.message ?: 0,
        cnt = from.cnt ?: 0,
        list = from.list?.map(forecastItemMapper::map) ?: emptyList(),
        city = forecastCityMapper.map(from.city),
    )
}
