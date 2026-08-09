package com.david.weatherchannel.core.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

/**
 * One feature's contribution to the host [androidx.navigation3.ui.NavDisplay]'s entry provider.
 * Inspiration from https://developer.android.com/guide/navigation/navigation-3/modularize
 */
typealias EntryProviderInstaller = EntryProviderScope<NavKey>.() -> Unit
