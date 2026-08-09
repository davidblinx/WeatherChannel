package com.david.weatherchannel.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.weatherchannel.core.mvi.delegate.MVI
import com.david.weatherchannel.core.mvi.delegate.mvi
import com.david.weatherchannel.core.navigation.NavigationOptions
import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.core.ui.state.asUIStateHolder
import com.david.weatherchannel.core.ui.state.mapSuccess
import com.david.weatherchannel.core.ui.state.toLoading
import com.david.weatherchannel.domain.repository.WeatherRepository
import com.david.weatherchannel.presentation.search.mapper.LocationResultUiModelMapper
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import com.david.weatherchannel.presentation.search.model.SearchAction
import com.david.weatherchannel.presentation.search.model.SearchScreenEvent
import com.david.weatherchannel.presentation.search.model.SearchScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val navigator: Navigator,
    private val weatherRepository: WeatherRepository,
    private val locationResultMapper: LocationResultUiModelMapper,
) : ViewModel(),
    MVI<SearchScreenState, SearchAction, SearchScreenEvent> by mvi(SearchScreenState()) {

    override fun onAction(action: SearchAction) {
        when (action) {
            is SearchAction.OnQueryChange -> updateState { copy(query = action.query) }
            SearchAction.OnSearchSubmit -> search()
            SearchAction.OnRetryClick -> search()
            is SearchAction.OnCitySelected -> navigateToWeatherDetails(action.location)
        }
    }

    private fun search() {
        val query = state.value.query
        if (query.isBlank()) return

        updateState { copy(results = toLoading()) }
        viewModelScope.launch {
            val holder = weatherRepository.getCoordinatesByLocationName(query).asUIStateHolder()
            updateState {
                copy(
                    results = holder.mapSuccess { locations -> locations.map(locationResultMapper::map).toImmutableList() },
                )
            }
        }
    }

    private fun navigateToWeatherDetails(location: LocationResultUiModel) {
        navigator.navigate(
            key = WeatherDetailsDestination(lat = location.latitude, lon = location.longitude),
            options = NavigationOptions(
                popUpTo = NavigationOptions.PopUpTo.Route(
                    route = WeatherDetailsDestination::class,
                    inclusive = true,
                ),
            ),
        )
    }
}
