plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt)
}

dependencies {
    implementation(projects.domain)
    implementation(projects.core.mvi)
    implementation(projects.core.mvvm)
    implementation(projects.core.navigation)
    implementation(projects.core.network)
    implementation(projects.core.permissions)
    implementation(projects.core.uiState)
    implementation(projects.core.coil)
    implementation(projects.presentation.shared.ui)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.hilt.lifecycle.viewmodel.compose)
}
