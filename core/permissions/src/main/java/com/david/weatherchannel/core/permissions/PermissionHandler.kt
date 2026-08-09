package com.david.weatherchannel.core.permissions

interface PermissionHandler {
    fun isPermissionGranted(permission: Permission): Boolean

    suspend fun requestPermission(permission: Permission): PermissionStatus
}
