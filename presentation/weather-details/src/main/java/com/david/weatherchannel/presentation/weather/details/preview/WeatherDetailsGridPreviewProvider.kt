package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class WeatherDetailsGridPreviewProvider : PreviewParameterProvider<ImmutableList<WeatherDetailItemUiModel>> {

    override val values: Sequence<ImmutableList<WeatherDetailItemUiModel>>
        get() = sequenceOf(
            persistentListOf(
                WeatherDetailItemUiModel(label = "Humidity", value = "72%"),
                WeatherDetailItemUiModel(label = "Wind", value = "3.6 m/s"),
                WeatherDetailItemUiModel(label = "Pressure", value = "1013 hPa"),
                WeatherDetailItemUiModel(label = "Visibility", value = "10.0 km"),
                WeatherDetailItemUiModel(label = "Sunrise", value = "06:12"),
                WeatherDetailItemUiModel(label = "Sunset", value = "20:45"),
            ),
        )
}
