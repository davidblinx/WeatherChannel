package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.david.weatherchannel.presentation.weather.details.model.CurrentWeatherHeaderUiModel

@Composable
fun CurrentWeatherHeader(
    uiModel: CurrentWeatherHeaderUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = uiModel.condition, style = MaterialTheme.typography.headlineSmall)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = uiModel.temperature, style = MaterialTheme.typography.displayLarge)
            AsyncImage(
                model = uiModel.iconUrl,
                contentDescription = uiModel.condition,
                modifier = Modifier.size(72.dp),
            )
        }

        Text(text = uiModel.feelsLike, style = MaterialTheme.typography.bodyLarge)

        Text(text = uiModel.highLow, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
private fun CurrentWeatherHeaderPreview() {
    CurrentWeatherHeader(uiModel = CurrentWeatherHeaderUiModel(
        locationName = "London",
        condition = "Cloudy",
        temperature = "17°",
        feelsLike = "Feels like 17°",
        highLow = "High 23° · Low 14°",
        iconUrl = "https://openweathermap.org/payload/api/media/file/04d@2x.png",
    ))
}
