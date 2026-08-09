package com.david.weatherchannel.domain.entity.weather

data class CurrentWeatherEntity(
    val coordinates: CoordinatesEntity,
    val weather: List<WeatherEntity>,
    val base: String,
    val main: MainWeatherEntity,
    val visibility: Int,
    val wind: WindEntity,
    val rain: RainEntity?,
    val snow: SnowEntity?,
    val clouds: CloudsEntity,
    val dt: Long,
    val sys: SysEntity,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)
