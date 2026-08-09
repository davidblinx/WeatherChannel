package com.david.weatherchannel.data.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.data.dto.weather.MainWeatherDto
import com.david.weatherchannel.domain.entity.weather.MainWeatherEntity
import javax.inject.Inject

class MainWeatherMapper @Inject constructor() : Mapper<MainWeatherDto?, MainWeatherEntity> {

    override fun map(from: MainWeatherDto?): MainWeatherEntity = MainWeatherEntity(
        temp = from?.temp ?: 0.0,
        feelsLike = from?.feelsLike ?: 0.0,
        tempMin = from?.tempMin ?: 0.0,
        tempMax = from?.tempMax ?: 0.0,
        pressure = from?.pressure ?: 0,
        humidity = from?.humidity ?: 0,
        seaLevel = from?.seaLevel ?: 0,
        groundLevel = from?.groundLevel ?: 0,
    )
}
