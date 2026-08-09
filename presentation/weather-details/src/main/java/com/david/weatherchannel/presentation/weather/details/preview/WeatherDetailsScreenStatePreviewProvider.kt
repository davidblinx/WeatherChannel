package com.david.weatherchannel.presentation.weather.details.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.david.weatherchannel.core.ui.state.UIState
import com.david.weatherchannel.core.ui.state.UIStateHolder
import com.david.weatherchannel.presentation.weather.details.model.CurrentWeatherHeaderUiModel
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsContentUiModel
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailsScreenState
import kotlinx.collections.immutable.persistentListOf

class WeatherDetailsScreenStatePreviewProvider : PreviewParameterProvider<WeatherDetailsScreenState> {

    override val values: Sequence<WeatherDetailsScreenState>
        get() = sequenceOf(
            WeatherDetailsScreenState(),
            WeatherDetailsScreenState(latitude = LATITUDE, longitude = LONGITUDE),
            WeatherDetailsScreenState(
                latitude = LATITUDE,
                longitude = LONGITUDE,
                weatherContent = UIStateHolder(uiState = UIState.Success, payload = contentUiModel()),
            ),
            WeatherDetailsScreenState(
                latitude = LATITUDE,
                longitude = LONGITUDE,
                weatherContent = UIStateHolder(
                    uiState = UIState.Success,
                    payload = contentUiModel().copy(forecast = persistentListOf()),
                ),
            ),
            WeatherDetailsScreenState(
                latitude = LATITUDE,
                longitude = LONGITUDE,
                weatherContent = UIStateHolder(uiState = UIState.Error(message = "Unable to load weather")),
            ),
        )

    private fun contentUiModel(): WeatherDetailsContentUiModel = WeatherDetailsContentUiModel(
        header = CurrentWeatherHeaderUiModel(
            locationName = "London",
            condition = "Cloudy",
            temperature = "17°",
            feelsLike = "Feels like 17°",
            highLow = "High 23° · Low 14°",
            iconUrl = "https://openweathermap.org/payload/api/media/file/04d@2x.png",
        ),
        details = persistentListOf(
            WeatherDetailItemUiModel(label = "Humidity", value = "72%"),
            WeatherDetailItemUiModel(label = "Wind", value = "3.6 m/s"),
            WeatherDetailItemUiModel(label = "Pressure", value = "1013 hPa"),
            WeatherDetailItemUiModel(label = "Visibility", value = "10.0 km"),
            WeatherDetailItemUiModel(label = "Sunrise", value = "06:12"),
            WeatherDetailItemUiModel(label = "Sunset", value = "20:45"),
        ),
        forecast = persistentListOf(
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
        ),
    )

    private companion object {
        const val LATITUDE = 51.5
        const val LONGITUDE = -0.12
    }
}
