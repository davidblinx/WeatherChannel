package com.david.weatherchannel.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.Snapshot
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

/**
 * Bridges [Navigator]'s action flow to a flat [NavBackStack]. Only collects while the
 * lifecycle is at least [minActiveState], so actions emitted while the host is backgrounded
 * are held on the buffered channel until collection resumes.
 */
@Composable
fun NavBackStackActions(
    navigator: Navigator,
    backStack: NavBackStack<NavKey>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.RESUMED,
    context: CoroutineContext = Dispatchers.Main.immediate,
) {
    LaunchedEffect(navigator, backStack) {
        navigator.navigationActions
            .flowWithLifecycle(lifecycleOwner.lifecycle, minActiveState)
            .flowOn(context)
            .collect { action -> backStack.applyNavigationAction(action) }
    }
}

internal fun MutableList<NavKey>.applyNavigationAction(action: NavigationAction) {
    // Batch the pop + push into one snapshot so NavDisplay sees a single change.
    Snapshot.withMutableSnapshot {
        when (action) {
            is NavigationAction.Navigate -> {
                applyPopUpTo(action.options.popUpTo)
                if (!action.options.launchSingleTop || lastOrNull() != action.key) {
                    add(action.key)
                }
            }

            NavigationAction.PopBackStack ->
                if (size > 1) {
                    removeAt(lastIndex)
                }
        }
    }
}

internal fun MutableList<NavKey>.applyPopUpTo(popUpTo: NavigationOptions.PopUpTo?) {
    if (popUpTo == null) return
    val anchor = when (popUpTo) {
        is NavigationOptions.PopUpTo.Key -> indexOfLast { it == popUpTo.key }
        is NavigationOptions.PopUpTo.Route -> indexOfLast { it::class == popUpTo.route }
    }
    if (anchor < 0) return
    val cutoff = if (popUpTo.inclusive) anchor else anchor + 1
    while (size > cutoff) {
        removeAt(lastIndex)
    }
}
