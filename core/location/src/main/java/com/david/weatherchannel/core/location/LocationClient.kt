package com.david.weatherchannel.core.location

import android.location.Location

interface LocationClient {
    suspend fun getCurrentLocation(): Location?
}
