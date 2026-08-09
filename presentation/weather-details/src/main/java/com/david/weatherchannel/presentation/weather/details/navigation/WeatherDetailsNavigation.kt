package com.david.weatherchannel.presentation.weather.details.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.presentation.weather.details.screen.WeatherDetailsRoute

fun EntryProviderScope<NavKey>.weatherDetailsNavigation() {
    entry<WeatherDetailsDestination> { destination ->
        WeatherDetailsRoute(destination = destination)
    }
}
