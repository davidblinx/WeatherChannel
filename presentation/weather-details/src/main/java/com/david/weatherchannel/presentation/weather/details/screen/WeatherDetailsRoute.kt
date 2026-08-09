package com.david.weatherchannel.presentation.weather.details.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.presentation.weather.details.viewmodel.WeatherDetailsViewModel

@Composable
fun WeatherDetailsRoute(
    destination: WeatherDetailsDestination,
    modifier: Modifier = Modifier,
    viewModel: WeatherDetailsViewModel = hiltViewModel<WeatherDetailsViewModel, WeatherDetailsViewModel.Factory>(
        creationCallback = { factory -> factory.create(destination) },
    ),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    WeatherDetailsScreen(
        state = state,
        onAction = viewModel::onAction,
        modifier = modifier,
    )
}
