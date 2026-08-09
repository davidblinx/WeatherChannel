package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastCityDto
import com.david.weatherchannel.domain.entity.weather.ForecastCityEntity
import javax.inject.Inject

class ForecastCityMapper @Inject constructor(
    private val coordinatesMapper: CoordinatesMapper,
) : Mapper<ForecastCityDto?, ForecastCityEntity> {

    override fun map(from: ForecastCityDto?): ForecastCityEntity = ForecastCityEntity(
        id = from?.id ?: 0,
        name = from?.name.orEmpty(),
        coordinates = coordinatesMapper.map(from?.coordinates),
        country = from?.country.orEmpty(),
        population = from?.population ?: 0,
        timezone = from?.timezone ?: 0,
        sunrise = from?.sunrise ?: 0L,
        sunset = from?.sunset ?: 0L,
    )
}
