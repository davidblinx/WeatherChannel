package com.david.weatherchannel.domain.usecase

import com.david.weatherchannel.domain.repository.LocationRepository
import javax.inject.Inject

class LoadCurrentLocationWeatherUseCase @Inject constructor(
    private val locationRepository: LocationRepository,
    private val loadWeatherDetailsUseCase: LoadWeatherDetailsUseCase,
) {

    suspend fun execute(): CurrentLocationWeather? {
        val coordinates = locationRepository.getCurrentLocation() ?: return null
        val weather = loadWeatherDetailsUseCase.execute(coordinates.latitude, coordinates.longitude)
        return CurrentLocationWeather(coordinates, weather)
    }
}
