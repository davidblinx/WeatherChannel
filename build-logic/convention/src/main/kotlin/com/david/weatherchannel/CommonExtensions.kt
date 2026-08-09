package com.david.weatherchannel

import com.android.build.api.dsl.CommonExtension

internal fun CommonExtension.configureBuildFeatures() {
    buildFeatures.apply {
        shaders = false
        buildConfig = true
    }
}
