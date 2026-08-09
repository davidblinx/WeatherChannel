package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.ForecastItemDto
import com.david.weatherchannel.domain.entity.weather.ForecastItemEntity
import javax.inject.Inject

class ForecastItemMapper @Inject constructor(
    private val mainWeatherMapper: MainWeatherMapper,
    private val weatherMapper: WeatherMapper,
    private val cloudsMapper: CloudsMapper,
    private val windMapper: WindMapper,
    private val forecastRainMapper: ForecastRainMapper,
    private val forecastSnowMapper: ForecastSnowMapper,
    private val forecastSysMapper: ForecastSysMapper,
) : Mapper<ForecastItemDto, ForecastItemEntity> {

    override fun map(from: ForecastItemDto): ForecastItemEntity = ForecastItemEntity(
        dt = from.dt ?: 0L,
        main = mainWeatherMapper.map(from.main),
        weather = from.weather?.map(weatherMapper::map) ?: emptyList(),
        clouds = cloudsMapper.map(from.clouds),
        wind = windMapper.map(from.wind),
        visibility = from.visibility ?: 0,
        pop = from.pop ?: 0.0,
        rain = from.rain?.let(forecastRainMapper::map),
        snow = from.snow?.let(forecastSnowMapper::map),
        sys = forecastSysMapper.map(from.sys),
        dtText = from.dtText.orEmpty(),
    )
}
