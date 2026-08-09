package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel
import kotlinx.collections.immutable.ImmutableList
import com.david.weatherchannel.presentation.weather.details.preview.ForecastRowPreviewProvider

@Composable
fun ForecastRow(
    days: ImmutableList<ForecastDayUiModel>,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text(
                text = "5-day forecast",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(days) { day -> ForecastDayItem(uiModel = day) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForecastRowPreview(
    @PreviewParameter(ForecastRowPreviewProvider::class) days: ImmutableList<ForecastDayUiModel>,
) {
    ForecastRow(days = days)
}
