package com.david.weatherchannel.presentation.weather.details.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.domain.entity.weather.ForecastEntity
import com.david.weatherchannel.domain.entity.weather.ForecastItemEntity
import com.david.weatherchannel.presentation.weather.details.model.ForecastDayUiModel
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.roundToInt

class ForecastDayUiModelMapper @Inject constructor() : Mapper<ForecastEntity, List<ForecastDayUiModel>> {

    override fun map(from: ForecastEntity): List<ForecastDayUiModel> {
        val zoneOffset = ZoneOffset.ofTotalSeconds(from.city.timezone)
        return from.list
            .groupBy { it.dt.toLocalDate(zoneOffset) }
            .toSortedMap()
            .values
            .take(FORECAST_DAY_COUNT)
            .mapIndexed { index, items -> items.toDayUiModel(index, zoneOffset) }
    }

    private fun List<ForecastItemEntity>.toDayUiModel(index: Int, zoneOffset: ZoneOffset): ForecastDayUiModel {
        val representative = minByOrNull { abs(it.dt.toLocalHour(zoneOffset) - NOON_HOUR) } ?: first()
        return ForecastDayUiModel(
            dayLabel = if (index == 0) TODAY_LABEL else representative.dt.toDayLabel(zoneOffset),
            iconUrl = representative.weather.firstOrNull()?.icon.orEmpty(),
            highTemp = "${maxOf { it.main.tempMax }.roundToInt()}°",
            lowTemp = "${minOf { it.main.tempMin }.roundToInt()}°",
            precipitationChance = "${(maxOf { it.pop } * PERCENTAGE_MULTIPLIER).roundToInt()}%",
        )
    }

    private fun Long.toLocalDate(zoneOffset: ZoneOffset): LocalDate =
        Instant.ofEpochSecond(this).atZone(zoneOffset).toLocalDate()

    private fun Long.toLocalHour(zoneOffset: ZoneOffset): Int =
        Instant.ofEpochSecond(this).atZone(zoneOffset).hour

    private fun Long.toDayLabel(zoneOffset: ZoneOffset): String =
        Instant.ofEpochSecond(this).atZone(zoneOffset).dayOfWeek
            .getDisplayName(TextStyle.SHORT, Locale.getDefault())

    private companion object {
        const val FORECAST_DAY_COUNT = 5
        const val NOON_HOUR = 12
        const val PERCENTAGE_MULTIPLIER = 100
        const val TODAY_LABEL = "Today"
    }
}
