package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlin.reflect.KClass

data class NavigationOptions(
    val popUpTo: PopUpTo? = null,
    val launchSingleTop: Boolean = true,
) {

    sealed interface PopUpTo {
        val inclusive: Boolean

        /** Pop up to the exact [key] instance already on the back stack. */
        data class Key(val key: NavKey, override val inclusive: Boolean = false) : PopUpTo

        /** Pop up to the most recent entry whose type is [route] */
        data class Route(val route: KClass<out NavKey>, override val inclusive: Boolean = false) : PopUpTo
    }
}
