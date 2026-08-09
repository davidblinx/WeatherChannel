plugins {
    alias(libs.plugins.convention.library)
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.mvvm)
}
