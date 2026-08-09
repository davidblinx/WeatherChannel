package com.david.weatherchannel.core.permissions

sealed interface PermissionStatus {

    data object Granted : PermissionStatus

    data class Denied(val shouldShowRationale: Boolean) : PermissionStatus
}

val PermissionStatus.isGranted: Boolean
    get() = this == PermissionStatus.Granted
