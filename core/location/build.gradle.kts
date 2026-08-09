plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    implementation(libs.play.services.location)
    implementation(projects.core.coroutines)
}
