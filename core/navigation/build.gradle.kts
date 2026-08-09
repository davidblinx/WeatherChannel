plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

dependencies {
    api(libs.androidx.navigation3.runtime)
    implementation(libs.bundles.coroutines)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.unit.test.junit)
    testImplementation(libs.unit.test.coroutines)
}
