package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class ForecastRowPreviewProvider : PreviewParameterProvider<ImmutableList<ForecastDayUiModel>> {

    override val values: Sequence<ImmutableList<ForecastDayUiModel>>
        get() = sequenceOf(
            persistentListOf(
                ForecastDayUiModel(
                    dayLabel = "Today",
                    iconUrl = "https://openweathermap.org/payload/api/media/file/04d@2x.png",
                    highTemp = "23°",
                    lowTemp = "14°",
                    precipitationChance = "70%",
                ),
                ForecastDayUiModel(
                    dayLabel = "Fri",
                    iconUrl = "https://openweathermap.org/payload/api/media/file/11d@2x.png",
                    highTemp = "20°",
                    lowTemp = "14°",
                    precipitationChance = "80%",
                ),
                ForecastDayUiModel(
                    dayLabel = "Sat",
                    iconUrl = "https://openweathermap.org/payload/api/media/file/11d@2x.png",
                    highTemp = "28°",
                    lowTemp = "16°",
                    precipitationChance = "40%",
                ),
                ForecastDayUiModel(
                    dayLabel = "Sun",
                    iconUrl = "https://openweathermap.org/payload/api/media/file/11d@2x.png",
                    highTemp = "30°",
                    lowTemp = "17°",
                    precipitationChance = "40%",
                ),
                ForecastDayUiModel(
                    dayLabel = "Mon",
                    iconUrl = "https://openweathermap.org/payload/api/media/file/11d@2x.png",
                    highTemp = "28°",
                    lowTemp = "17°",
                    precipitationChance = "50%",
                ),
            ),
        )
}
