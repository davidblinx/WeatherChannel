package com.david.weatherchannel.presentation.weather.details.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.david.weatherchannel.core.navigation.WeatherDetailsDestination
import com.david.weatherchannel.core.permissions.Permission
import com.david.weatherchannel.core.permissions.isGranted
import com.david.weatherchannel.core.permissions.rememberPermissionHandler
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsAction
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

    if (destination.lat == null && destination.lon == null) {
        val permissionHandler = rememberPermissionHandler()
        LaunchedEffect(Unit) {
            val granted = permissionHandler.isPermissionGranted(Permission.LOCATION) ||
                permissionHandler.requestPermission(Permission.LOCATION).isGranted
            viewModel.onAction(WeatherDetailsAction.OnLocationPermissionResult(granted))
        }
    }

    WeatherDetailsScreen(
        state = state,
        onAction = viewModel::onAction,
        modifier = modifier,
    )
}
