plugins {
    alias(libs.plugins.convention.app)
}

android {
    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.core.navigation)
    implementation(projects.presentation.search)
    implementation(projects.presentation.weatherDetails)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation3.ui)
    testImplementation(libs.unit.test.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
