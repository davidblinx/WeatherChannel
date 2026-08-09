import com.david.weatherchannel.getPropertiesIfExist

plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.kotlin.serialization)
    alias(libs.plugins.convention.hilt)
}

val apiProperties = getPropertiesIfExist(
    fileName = "api.properties",
    message = "Missing core/api/api.properties. Copy core/api/api.properties.example to " +
        "core/api/api.properties and fill in your OpenWeatherMap API key.",
)

android {
    defaultConfig {
        buildConfigField("String", "API_KEY", "\"${apiProperties?.getProperty("apiKey").orEmpty()}\"")
        val baseUrl = apiProperties?.getProperty("baseUrl").orEmpty()
        buildConfigField(
            "String",
            "WEATHER_BASE_URL",
            "\"$baseUrl${apiProperties?.getProperty("weatherPath").orEmpty()}\"",
        )
        buildConfigField(
            "String",
            "WEATHER_API_VERSION",
            "\"${apiProperties?.getProperty("weatherApiVersion").orEmpty()}\"",
        )
        buildConfigField(
            "String",
            "GEOCODING_BASE_URL",
            "\"$baseUrl${apiProperties?.getProperty("geocodingPath").orEmpty()}\"",
        )
        buildConfigField(
            "String",
            "GEOCODING_API_VERSION",
            "\"${apiProperties?.getProperty("geocodingApiVersion").orEmpty()}\"",
        )
    }
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.location)
    implementation(projects.domain)
    implementation(projects.core.mvvm)
}
