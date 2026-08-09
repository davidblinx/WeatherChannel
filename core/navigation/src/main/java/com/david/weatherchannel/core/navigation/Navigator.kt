package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.flow.Flow

interface Navigator {

    /**
     * Buffered stream of pending navigation intents. Feature imply call [navigate] / [navigateUp]
     * and stay decoupled from how the host drains them.
     */
    val navigationActions: Flow<NavigationAction>

    /** Navigate to [key] with app-supported Navigation 3 options. */
    fun navigate(key: NavKey, options: NavigationOptions = NavigationOptions())

    /** Pop the top of the back stack (no-op if only one entry remains). */
    fun navigateUp()
}
