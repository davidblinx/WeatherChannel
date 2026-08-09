package com.david.weatherchannel.domain.entity.weather

data class SysEntity(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)
