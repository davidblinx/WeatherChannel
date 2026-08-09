package com.david.weatherchannel.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import com.david.weatherchannel.core.mvi.delegate.MVI
import com.david.weatherchannel.core.mvi.delegate.mvi
import com.david.weatherchannel.core.navigation.NavigationOptions
import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.presentation.search.model.SearchAction
import com.david.weatherchannel.presentation.search.model.SearchScreenEvent
import com.david.weatherchannel.presentation.search.model.SearchScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(),
    MVI<SearchScreenState, SearchAction, SearchScreenEvent> by mvi(SearchScreenState) {

    override fun onAction(action: SearchAction) {
        when (action) {
            is SearchAction.OnCitySelected ->
                navigator.navigate(
                    key = WeatherDetailsDestination(action.lat, action.lon),
                    options = NavigationOptions(
                        popUpTo = NavigationOptions.PopUpTo.Route(
                            route = WeatherDetailsDestination::class,
                            inclusive = true,
                        ),
                    ),
                )
        }
    }
}
