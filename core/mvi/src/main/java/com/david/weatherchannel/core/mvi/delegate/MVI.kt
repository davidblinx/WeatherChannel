package com.david.weatherchannel.core.mvi.delegate

import com.david.weatherchannel.core.mvi.action.Action
import com.david.weatherchannel.core.mvi.event.Event
import com.david.weatherchannel.core.mvi.state.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVI<S : State, A : Action, E : Event> {
    val state: StateFlow<S>
    val events: Flow<E>

    fun onAction(action: A)

    fun updateState(block: S.() -> S)

    fun updateState(newState: S)

    fun CoroutineScope.emitEvent(event: E)
    suspend fun emitEvent(event: E)
}
