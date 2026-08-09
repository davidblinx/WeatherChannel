package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.CurrentWeatherResponseDto
import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity
import javax.inject.Inject

class CurrentWeatherMapper @Inject constructor(
    private val coordinatesMapper: CoordinatesMapper,
    private val weatherMapper: WeatherMapper,
    private val mainWeatherMapper: MainWeatherMapper,
    private val windMapper: WindMapper,
    private val rainMapper: RainMapper,
    private val snowMapper: SnowMapper,
    private val cloudsMapper: CloudsMapper,
    private val sysMapper: SysMapper,
) : Mapper<CurrentWeatherResponseDto, CurrentWeatherEntity> {

    override fun map(from: CurrentWeatherResponseDto): CurrentWeatherEntity = CurrentWeatherEntity(
        coordinates = coordinatesMapper.map(from.coordinates),
        weather = from.weather?.map(weatherMapper::map) ?: emptyList(),
        base = from.base.orEmpty(),
        main = mainWeatherMapper.map(from.main),
        visibility = from.visibility ?: 0,
        wind = windMapper.map(from.wind),
        rain = from.rain?.let(rainMapper::map),
        snow = from.snow?.let(snowMapper::map),
        clouds = cloudsMapper.map(from.clouds),
        dt = from.dt ?: 0L,
        sys = sysMapper.map(from.sys),
        timezone = from.timezone ?: 0,
        id = from.id ?: 0,
        name = from.name.orEmpty(),
        cod = from.cod ?: 0,
    )
}
