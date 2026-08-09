pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "WeatherChannel"
include(":app")
include(":data")
include(":core:coil")
include(":core:coroutines")
include(":core:location")
include(":core:mvi")
include(":core:mvvm")
include(":core:navigation")
include(":core:network")
include(":core:permissions")
include(":core:resources")
include(":core:ui-state")
include(":domain")
include(":presentation:shared:ui")
include(":presentation:weather-details")
include(":presentation:search")
