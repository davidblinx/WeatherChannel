package com.david.weatherchannel.domain.entity.weather

data class WeatherEntity(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)
