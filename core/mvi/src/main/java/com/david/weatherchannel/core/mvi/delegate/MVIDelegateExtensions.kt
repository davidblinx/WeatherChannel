package com.david.weatherchannel.core.mvi.delegate

import com.david.weatherchannel.core.mvi.action.Action
import com.david.weatherchannel.core.mvi.event.Event
import com.david.weatherchannel.core.mvi.state.State

fun <S : State, A : Action, E : Event> mvi(initialState: S): MVI<S, A, E> =
    MVIDelegate(initialState)
