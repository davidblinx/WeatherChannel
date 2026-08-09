package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.NavKey

sealed interface NavigationAction {

    /** Push [destination] onto the back stack */
    data class Navigate(val key: NavKey, val options: NavigationOptions) : NavigationAction

    /** Pop the top of the back stack. */
    data object PopBackStack : NavigationAction
}
