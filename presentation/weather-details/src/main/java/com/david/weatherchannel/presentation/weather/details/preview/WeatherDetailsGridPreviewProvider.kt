package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.core.resources.R
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class WeatherDetailsGridPreviewProvider : PreviewParameterProvider<ImmutableList<WeatherDetailItemUiModel>> {

    override val values: Sequence<ImmutableList<WeatherDetailItemUiModel>>
        get() = sequenceOf(
            persistentListOf(
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_humidity, value = "72%"),
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_wind, value = "3.6 m/s"),
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_pressure, value = "1013 hPa"),
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_visibility, value = "10.0 km"),
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_sunrise, value = "06:12"),
                WeatherDetailItemUiModel(labelRes = R.string.weather_detail_label_sunset, value = "20:45"),
            ),
        )
}
