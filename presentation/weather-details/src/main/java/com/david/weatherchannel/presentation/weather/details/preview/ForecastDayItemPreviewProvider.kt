package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel

class ForecastDayItemPreviewProvider : PreviewParameterProvider<ForecastDayUiModel> {

    override val values: Sequence<ForecastDayUiModel>
        get() = sequenceOf(
            ForecastDayUiModel(
                dayLabel = "Today",
                iconUrl = "https://openweathermap.org/payload/api/media/file/04d@2x.png",
                highTemp = "23°",
                lowTemp = "14°",
                precipitationChance = "70%",
            ),
        )
}
