package com.david.weatherchannel.presentation.weather.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.weatherchannel.core.mvi.delegate.MVI
import com.david.weatherchannel.core.mvi.delegate.mvi
import com.david.weatherchannel.core.navigation.NavigationOptions
import com.david.weatherchannel.core.navigation.Navigator
import com.david.weatherchannel.core.navigation.SearchDestination
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.core.ui.state.asUIStateHolder
import com.david.weatherchannel.core.ui.state.mapSuccess
import com.david.weatherchannel.core.ui.state.toLoading
import com.david.weatherchannel.domain.usecase.LoadCurrentLocationWeatherUseCase
import com.david.weatherchannel.domain.usecase.LoadWeatherDetailsUseCase
import com.david.weatherchannel.domain.usecase.WeatherContent
import com.david.weatherchannel.presentation.weather.details.mapper.CurrentWeatherHeaderUiModelMapper
import com.david.weatherchannel.presentation.weather.details.mapper.ForecastDayUiModelMapper
import com.david.weatherchannel.presentation.weather.details.mapper.WeatherDetailItemsUiModelMapper
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsAction
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsContentUiModel
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenEvent
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = WeatherDetailsViewModel.Factory::class)
class WeatherDetailsViewModel @AssistedInject constructor(
    @Assisted private val destination: WeatherDetailsDestination,
    private val navigator: Navigator,
    private val loadCurrentLocationWeatherUseCase: LoadCurrentLocationWeatherUseCase,
    private val loadWeatherDetailsUseCase: LoadWeatherDetailsUseCase,
    private val currentWeatherHeaderMapper: CurrentWeatherHeaderUiModelMapper,
    private val weatherDetailItemsMapper: WeatherDetailItemsUiModelMapper,
    private val forecastDayMapper: ForecastDayUiModelMapper,
) : ViewModel(),
    MVI<WeatherDetailsScreenState, WeatherDetailsAction, WeatherDetailsScreenEvent> by mvi(
        WeatherDetailsScreenState(latitude = destination.lat, longitude = destination.lon),
    ) {

    init {
        fetchWeather()
    }

    override fun onAction(action: WeatherDetailsAction) {
        when (action) {
            WeatherDetailsAction.OnRetryClick -> fetchWeather()
            WeatherDetailsAction.OnSearchClick -> navigateToSearch()
            is WeatherDetailsAction.OnLocationPermissionResult -> resolveCurrentLocation(action.granted)
        }
    }

    private fun fetchWeather() {
        val lat = state.value.latitude
        val lon = state.value.longitude
        if (lat == null || lon == null) return

        updateState { copy(weatherContent = toLoading()) }
        viewModelScope.launch {
            val holder = loadWeatherDetailsUseCase.execute(lat, lon).asUIStateHolder()
            updateState { copy(weatherContent = holder.mapSuccess(::toContentUiModel)) }
        }
    }

    private fun resolveCurrentLocation(granted: Boolean) {
        viewModelScope.launch {
            val result = if (granted) {
                updateState { copy(weatherContent = toLoading()) }
                loadCurrentLocationWeatherUseCase.execute()
            } else {
                null
            }

            if (result == null) {
                updateState { copy(isLocationUnavailable = true) }
                return@launch
            }

            updateState {
                copy(
                    latitude = result.coordinates.latitude,
                    longitude = result.coordinates.longitude,
                    weatherContent = result.weather.asUIStateHolder().mapSuccess(::toContentUiModel),
                )
            }
        }
    }

    private fun toContentUiModel(content: WeatherContent): WeatherDetailsContentUiModel =
        WeatherDetailsContentUiModel(
            header = currentWeatherHeaderMapper.map(content.currentWeather),
            details = weatherDetailItemsMapper.map(content.currentWeather).toImmutableList(),
            forecast = content.forecast?.let(forecastDayMapper::map)?.toImmutableList() ?: persistentListOf(),
        )

    private fun navigateToSearch() {
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

    @AssistedFactory
    interface Factory {
        fun create(destination: WeatherDetailsDestination): WeatherDetailsViewModel
    }
}
