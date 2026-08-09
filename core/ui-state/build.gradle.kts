plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
}

dependencies {
    implementation(projects.core.network)
}
