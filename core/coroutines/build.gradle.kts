plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    api(libs.bundles.coroutines)

    testImplementation(libs.unit.test.junit)
    testImplementation(libs.unit.test.coroutines)
}
