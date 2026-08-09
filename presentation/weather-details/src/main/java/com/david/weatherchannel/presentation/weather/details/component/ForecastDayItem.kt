package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel
import com.david.weatherchannel.presentation.weather.details.preview.ForecastDayItemPreviewProvider

@Composable
fun ForecastDayItem(
    uiModel: ForecastDayUiModel,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(text = uiModel.dayLabel, style = MaterialTheme.typography.labelLarge)

            AsyncImage(
                model = uiModel.iconUrl,
                contentDescription = uiModel.dayLabel,
                modifier = Modifier.size(40.dp),
            )

            Text(text = uiModel.precipitationChance, style = MaterialTheme.typography.labelSmall)

            Text(text = uiModel.highTemp, style = MaterialTheme.typography.titleMedium)

            Text(text = uiModel.lowTemp, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForecastDayItemPreview(
    @PreviewParameter(ForecastDayItemPreviewProvider::class) uiModel: ForecastDayUiModel,
) {
    ForecastDayItem(uiModel = uiModel)
}
