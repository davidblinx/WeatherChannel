package com.david.weatherchannel.presentation.weather.details.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.core.ui.state.RenderContent
import com.david.weatherchannel.presentation.shared.ui.ErrorContent
import com.david.weatherchannel.presentation.shared.ui.LoadingContent
import com.david.weatherchannel.presentation.weather.details.component.CurrentWeatherHeader
import com.david.weatherchannel.presentation.weather.details.component.ForecastRow
import com.david.weatherchannel.presentation.weather.details.component.NoLocationSelected
import com.david.weatherchannel.presentation.weather.details.component.WeatherDetailsGrid
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsAction
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenState
import com.david.weatherchannel.presentation.weather.details.preview.WeatherDetailsScreenStatePreviewProvider

@Composable
fun WeatherDetailsScreen(
    state: WeatherDetailsScreenState,
    onAction: (WeatherDetailsAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { onAction(WeatherDetailsAction.OnSearchClick) }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search for a city")
            }
        },
    ) { innerPadding ->
        if (state.latitude == null || state.longitude == null) {
            NoLocationSelected(
                onSearchClick = { onAction(WeatherDetailsAction.OnSearchClick) },
                modifier = Modifier.fillMaxSize().padding(innerPadding),
            )
        } else {
            state.weatherContent.RenderContent(
                loadingContent = { LoadingContent(modifier = Modifier.padding(innerPadding)) },
                errorContent = { message ->
                    ErrorContent(
                        message = message,
                        onRetry = { onAction(WeatherDetailsAction.OnRetryClick) },
                        modifier = Modifier.padding(innerPadding),
                    )
                },
                successContent = { content ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        CurrentWeatherHeader(uiModel = content.header)

                        WeatherDetailsGrid(
                            items = content.details,
                            modifier = Modifier.padding(horizontal = 16.dp),
                        )

                        if (content.forecast.isNotEmpty()) {
                            ForecastRow(
                                days = content.forecast,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                        }
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDetailsScreenPreview(
    @PreviewParameter(WeatherDetailsScreenStatePreviewProvider::class) state: WeatherDetailsScreenState,
) {
    WeatherDetailsScreen(state = state, onAction = {})
}
