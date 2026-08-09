package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.david.weatherchannel.core.resources.R
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import com.david.weatherchannel.presentation.weather.details.preview.WeatherDetailsGridPreviewProvider
import kotlinx.collections.immutable.ImmutableList

@Composable
fun WeatherDetailsGrid(
    items: ImmutableList<WeatherDetailItemUiModel>,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = stringResource(R.string.weather_details_section_title), style = MaterialTheme.typography.titleMedium)

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                maxItemsInEachRow = 2,
            ) {
                items.forEach { item ->
                    WeatherDetailItem(uiModel = item, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDetailsGridPreview(
    @PreviewParameter(WeatherDetailsGridPreviewProvider::class) items: ImmutableList<WeatherDetailItemUiModel>,
) {
    WeatherDetailsGrid(items = items)
}
