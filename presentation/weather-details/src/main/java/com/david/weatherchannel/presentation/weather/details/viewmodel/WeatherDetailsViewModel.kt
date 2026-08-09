package com.david.weatherchannel.presentation.weather.details.viewmodel

import androidx.lifecycle.ViewModel
import com.david.weatherchannel.core.mvi.delegate.MVI
import com.david.weatherchannel.core.mvi.delegate.mvi
import com.david.weatherchannel.core.navigation.NavigationOptions
import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.SearchDestination
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsAction
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenEvent
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherDetailsViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(),
    MVI<WeatherDetailsScreenState, WeatherDetailsAction, WeatherDetailsScreenEvent> by mvi(
        WeatherDetailsScreenState,
    ) {

    override fun onAction(action: WeatherDetailsAction) {
        when (action) {
            WeatherDetailsAction.OnSearchClick ->
                navigator.navigate(
                    key = SearchDestination,
                    options = NavigationOptions(
                        popUpTo = NavigationOptions.PopUpTo.Route(
                            route = SearchDestination::class,
                            inclusive = true,
                        ),
                    ),
                )
        }
    }
}
