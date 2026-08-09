plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    implementation(projects.core.coroutines)

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
}
