package com.david.weatherchannel.presentation.weather.details.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import com.david.weatherchannel.presentation.weather.details.preview.WeatherDetailItemPreviewProvider

@Composable
fun WeatherDetailItem(
    uiModel: WeatherDetailItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = uiModel.label, style = MaterialTheme.typography.labelMedium)
        Text(text = uiModel.value, style = MaterialTheme.typography.titleMedium)
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDetailItemPreview(
    @PreviewParameter(WeatherDetailItemPreviewProvider::class) uiModel: WeatherDetailItemUiModel,
) {
    WeatherDetailItem(uiModel = uiModel)
}
