package com.david.weatherchannel.domain.entity.weather

data class ForecastItemEntity(
    val dt: Long,
    val main: MainWeatherEntity,
    val weather: List<WeatherEntity>,
    val clouds: CloudsEntity,
    val wind: WindEntity,
    val visibility: Int,
    val pop: Double,
    val rain: ForecastRainEntity?,
    val snow: ForecastSnowEntity?,
    val sys: ForecastSysEntity,
    val dtText: String,
)
