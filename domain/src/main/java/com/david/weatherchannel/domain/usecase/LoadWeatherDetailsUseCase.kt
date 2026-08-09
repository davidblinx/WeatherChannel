package com.david.weatherchannel.domain.usecase

import com.david.weatherchannel.core.coroutines.IODispatcher
import com.david.weatherchannel.core.network.ApiResponse
import com.david.weatherchannel.core.network.getOrNull
import com.david.weatherchannel.core.network.mapSuccess
import com.david.weatherchannel.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Loads everything the weather details screen needs, from two independent network calls.
 */
class LoadWeatherDetailsUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun execute(latitude: Double, longitude: Double): ApiResponse<WeatherContent> =
        withContext(ioDispatcher) {
            val currentWeatherDeferred =
                async { weatherRepository.getWeatherByCoordinates(latitude, longitude) }
            val forecastDeferred =
                async { weatherRepository.getForecastByCoordinates(latitude, longitude) }

            val currentWeather = currentWeatherDeferred.await()
            val forecast = forecastDeferred.await()

            currentWeather.mapSuccess {
                WeatherContent(
                    currentWeather = this,
                    forecast = forecast.getOrNull()
                )
            }
        }
}
