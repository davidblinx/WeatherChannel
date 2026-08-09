package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel

class WeatherDetailItemPreviewProvider : PreviewParameterProvider<WeatherDetailItemUiModel> {

    override val values: Sequence<WeatherDetailItemUiModel>
        get() = sequenceOf(
            WeatherDetailItemUiModel(label = "Humidity", value = "72%"),
        )
}
