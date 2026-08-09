package com.david.weatherchannel.data.service

import com.david.weatherchannel.data.ApiConfig
import com.david.weatherchannel.data.dto.geocoding.GeocodingResultDto
import com.david.weatherchannel.data.dto.weather.CurrentWeatherResponseDto
import com.david.weatherchannel.data.dto.weather.ForecastResponseDto
import com.david.weatherchannel.core.network.ApiResponse
import com.david.weatherchannel.core.network.getApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import javax.inject.Inject

class WeatherService @Inject constructor(
    private val httpClient: HttpClient,
) {

    suspend fun getWeatherByCoordinates(
        latitude: Double,
        longitude: Double,
        lang: String? = null,
    ): ApiResponse<CurrentWeatherResponseDto> =
        httpClient.getApiResponse("${ApiConfig.WEATHER_BASE_URL}/${ApiConfig.WEATHER_API_VERSION}${ApiEndpoints.WEATHER}") {
            parameter(WeatherApiParams.LATITUDE, latitude)
            parameter(WeatherApiParams.LONGITUDE, longitude)
            parameter(WeatherApiParams.APP_ID, ApiConfig.API_KEY)
            parameter(WeatherApiParams.UNITS, ApiConfig.UNITS_METRIC)
            lang?.let { parameter(WeatherApiParams.LANG, it) }
        }

    suspend fun getForecastByCoordinates(
        latitude: Double,
        longitude: Double,
        lang: String? = null,
    ): ApiResponse<ForecastResponseDto> =
        httpClient.getApiResponse("${ApiConfig.WEATHER_BASE_URL}/${ApiConfig.WEATHER_API_VERSION}${ApiEndpoints.FORECAST}") {
            parameter(WeatherApiParams.LATITUDE, latitude)
            parameter(WeatherApiParams.LONGITUDE, longitude)
            parameter(WeatherApiParams.APP_ID, ApiConfig.API_KEY)
            parameter(WeatherApiParams.UNITS, ApiConfig.UNITS_METRIC)
            lang?.let { parameter(WeatherApiParams.LANG, it) }
        }

    suspend fun getCoordinatesByLocationName(
        query: String,
    ): ApiResponse<List<GeocodingResultDto>> =
        httpClient.getApiResponse("${ApiConfig.GEOCODING_BASE_URL}/${ApiConfig.GEOCODING_API_VERSION}${ApiEndpoints.DIRECT}") {
            parameter(GeocodingApiParams.QUERY, query)
            parameter(GeocodingApiParams.APP_ID, ApiConfig.API_KEY)
            parameter(GeocodingApiParams.LIMIT, 10)
        }
}
