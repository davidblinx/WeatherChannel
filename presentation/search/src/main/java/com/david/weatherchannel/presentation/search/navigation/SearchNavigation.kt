package com.david.weatherchannel.presentation.search.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.david.weatherchannel.core.navigation.SearchDestination
import com.david.weatherchannel.presentation.search.screen.SearchRoute

fun EntryProviderScope<NavKey>.searchNavigation() {
    entry<SearchDestination> {
        SearchRoute()
    }
}
