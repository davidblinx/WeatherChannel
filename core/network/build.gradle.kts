plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

dependencies {
    api(libs.bundles.ktor)
}
