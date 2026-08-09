package com.david.weatherchannel.presentation.weather.details.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.domain.entity.weather.CurrentWeatherEntity
import com.david.weatherchannel.presentation.weather.details.model.CurrentWeatherHeaderUiModel
import javax.inject.Inject
import kotlin.math.roundToInt

class CurrentWeatherHeaderUiModelMapper @Inject constructor() :
    Mapper<CurrentWeatherEntity, CurrentWeatherHeaderUiModel> {

    override fun map(from: CurrentWeatherEntity): CurrentWeatherHeaderUiModel {
        val weather = from.weather.firstOrNull()
        return CurrentWeatherHeaderUiModel(
            locationName = from.name,
            condition = weather?.main.orEmpty(),
            temperature = "${from.main.temp.roundToInt()}°",
            feelsLike = "Feels like ${from.main.feelsLike.roundToInt()}°",
            highLow = "High ${from.main.tempMax.roundToInt()}° · Low ${from.main.tempMin.roundToInt()}°",
            iconUrl = weather?.icon.orEmpty(),
        )
    }
}
