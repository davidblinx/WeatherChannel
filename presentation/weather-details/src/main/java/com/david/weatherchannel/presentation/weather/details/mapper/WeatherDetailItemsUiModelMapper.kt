package com.david.weatherchannel.presentation.weather.details.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity
import com.david.weatherchannel.presentation.weather.details.model.WeatherDetailItemUiModel
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class WeatherDetailItemsUiModelMapper @Inject constructor() :
    Mapper<CurrentWeatherEntity, List<WeatherDetailItemUiModel>> {

    override fun map(from: CurrentWeatherEntity): List<WeatherDetailItemUiModel> {
        val zoneOffset = ZoneOffset.ofTotalSeconds(from.timezone)
        return listOf(
            WeatherDetailItemUiModel(label = "Humidity", value = "${from.main.humidity}%"),
            WeatherDetailItemUiModel(label = "Wind", value = "%.1f m/s".format(from.wind.speed)),
            WeatherDetailItemUiModel(label = "Pressure", value = "${from.main.pressure} hPa"),
            WeatherDetailItemUiModel(
                label = "Visibility",
                value = "%.1f km".format(from.visibility / METERS_PER_KILOMETER),
            ),
            WeatherDetailItemUiModel(label = "Sunrise", value = from.sys.sunrise.toLocalTime(zoneOffset)),
            WeatherDetailItemUiModel(label = "Sunset", value = from.sys.sunset.toLocalTime(zoneOffset)),
        )
    }

    private fun Long.toLocalTime(zoneOffset: ZoneOffset): String =
        TIME_FORMATTER.format(Instant.ofEpochSecond(this).atZone(zoneOffset))

    private companion object {
        const val METERS_PER_KILOMETER = 1000.0
        val TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    }
}
