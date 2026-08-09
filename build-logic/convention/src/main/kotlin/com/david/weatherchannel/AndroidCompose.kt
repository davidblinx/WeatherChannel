package com.david.weatherchannel

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension,
) {
    commonExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        dependencies {
            "implementation"(libs.getBundle("compose"))
            "implementation"(libs.getBundle("compose-animations"))
            "implementation"(libs.getBundle("compose-graphics"))
            "implementation"(libs.getLibrary("kotlin-immutable-collections"))
            "debugImplementation"(libs.getBundle("compose-debug"))
            "androidTestImplementation"(libs.getBundle("compose-test"))
        }
    }
}
