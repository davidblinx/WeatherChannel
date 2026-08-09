package com.david.weatherchannel.presentation.search.model

import com.david.weatherchannel.core.mvi.state.State
import com.david.weatherchannel.core.ui.state.UIStateHolder
import com.david.weatherchannel.core.ui.state.toIdle
import kotlinx.collections.immutable.ImmutableList

data class SearchScreenState(
    val query: String = "",
    val results: UIStateHolder<ImmutableList<LocationResultUiModel>> = toIdle(),
) : State
