package com.david.weatherchannel.domain.entity.weather

data class ForecastCityEntity(
    val id: Int,
    val name: String,
    val coordinates: CoordinatesEntity,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long,
)
