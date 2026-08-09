package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDetailsDestination(
    val lat: Double? = null,
    val lon: Double? = null,
) : NavKey
