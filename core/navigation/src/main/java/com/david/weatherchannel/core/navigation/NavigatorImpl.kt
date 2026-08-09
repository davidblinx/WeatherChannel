package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {

    private val actions = Channel<NavigationAction>(capacity = Channel.UNLIMITED)

    override val navigationActions: Flow<NavigationAction> = actions.receiveAsFlow()

    override fun navigate(key: NavKey, options: NavigationOptions) {
        actions.trySend(NavigationAction.Navigate(key, options))
    }

    override fun navigateUp() {
        actions.trySend(NavigationAction.PopBackStack)
    }
}
