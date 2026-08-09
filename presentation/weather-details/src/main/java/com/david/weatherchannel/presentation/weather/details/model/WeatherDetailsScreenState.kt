package com.david.weatherchannel.presentation.weather.details.model

import com.david.weatherchannel.core.mvi.state.State
import com.david.weatherchannel.core.ui.state.UIStateHolder
import com.david.weatherchannel.core.ui.state.toLoading

data class WeatherDetailsScreenState(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val isLocationUnavailable: Boolean = false,
    val weatherContent: UIStateHolder<WeatherDetailsContentUiModel> = toLoading(),
) : State
