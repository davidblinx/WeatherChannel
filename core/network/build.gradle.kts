plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    api(libs.bundles.ktor)
    implementation(libs.kotlin.serialization.json)
}
