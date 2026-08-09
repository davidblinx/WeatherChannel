package com.david.weatherchannel.presentation.search.mapper

import com.david.weatherchannel.core.mvvm.mapper.Mapper
import com.david.weatherchannel.domain.entity.geocoding.GeocodingResultEntity
import com.david.weatherchannel.presentation.search.model.LocationResultUiModel
import javax.inject.Inject

class LocationResultUiModelMapper @Inject constructor() : Mapper<GeocodingResultEntity, LocationResultUiModel> {

    override fun map(from: GeocodingResultEntity): LocationResultUiModel = LocationResultUiModel(
        displayName = buildDisplayName(from),
        latitude = from.latitude,
        longitude = from.longitude,
    )

    private fun buildDisplayName(entity: GeocodingResultEntity): String =
        listOfNotNull(entity.name, entity.state, entity.country)
            .filter { it.isNotBlank() }
            .joinToString(", ")
}
