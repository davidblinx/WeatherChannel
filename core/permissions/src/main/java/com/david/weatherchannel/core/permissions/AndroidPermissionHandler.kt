package com.david.weatherchannel.core.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.random.Random

@Composable
fun rememberPermissionHandler(): PermissionHandler {
    val activity = LocalActivity.current as ComponentActivity
    return remember(activity) {
        AndroidPermissionHandler(activity)
    }
}

class AndroidPermissionHandler(private val activity: ComponentActivity) : PermissionHandler {

    private var currentLauncher: ActivityResultLauncher<String>? = null

    init {
        activity.lifecycle.addObserver(
            object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    currentLauncher?.unregister()
                    currentLauncher = null
                }
            },
        )
    }

    override fun isPermissionGranted(permission: Permission): Boolean =
        when (permission) {
            Permission.LOCATION -> ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            ) == PackageManager.PERMISSION_GRANTED
        }

    override suspend fun requestPermission(permission: Permission): PermissionStatus =
        when (permission) {
            Permission.LOCATION -> requestLocationPermission()
        }

    private suspend fun requestLocationPermission(): PermissionStatus =
        requestPermission(Manifest.permission.ACCESS_COARSE_LOCATION)

    private suspend fun requestPermission(permission: String): PermissionStatus =
        suspendCancellableCoroutine { continuation ->
            currentLauncher?.unregister()

            val launcher = activity.activityResultRegistry.register(
                "permission_${Random.nextInt()}",
                ActivityResultContracts.RequestPermission(),
            ) { isGranted ->
                currentLauncher?.unregister()
                currentLauncher = null
                if (isGranted) {
                    continuation.resume(PermissionStatus.Granted)
                } else {
                    val shouldShowRationale =
                        ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
                    continuation.resume(PermissionStatus.Denied(shouldShowRationale))
                }
            }
            currentLauncher = launcher

            continuation.invokeOnCancellation {
                currentLauncher?.unregister()
                currentLauncher = null
            }

            launcher.launch(permission)
        }
}
