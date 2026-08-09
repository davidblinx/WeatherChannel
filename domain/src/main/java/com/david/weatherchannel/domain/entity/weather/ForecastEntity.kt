package com.david.weatherchannel.domain.entity.weather

data class ForecastEntity(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ForecastItemEntity>,
    val city: ForecastCityEntity,
)
