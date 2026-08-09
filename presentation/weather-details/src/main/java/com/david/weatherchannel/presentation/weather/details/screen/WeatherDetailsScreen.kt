package com.david.weatherchannel.presentation.weather.details.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsAction
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenState

@Composable
fun WeatherDetailsScreen(
    state: WeatherDetailsScreenState,
    onAction: (WeatherDetailsAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(text = "Weather Details")
            Button(onClick = { onAction(WeatherDetailsAction.OnSearchClick) }) {
                Text(text = "Search")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDetailsScreenPreview() {
    WeatherDetailsScreen(
        state = WeatherDetailsScreenState,
        onAction = {},
    )
}
