package com.david.weatherchannel.core.mvi.delegate

import com.david.weatherchannel.core.mvi.action.Action
import com.david.weatherchannel.core.mvi.event.Event
import com.david.weatherchannel.core.mvi.state.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MVIDelegate<S : State, A : Action, E : Event> internal constructor(initialState: S) :
    MVI<S, A, E> {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    override val state: StateFlow<S> = _state.asStateFlow()

    private val _events: Channel<E> by lazy { Channel() }
    override val events: Flow<E> by lazy { _events.receiveAsFlow() }

    override fun onAction(action: A) {}

    override fun updateState(newState: S) {
        _state.update { newState }
    }

    override fun updateState(block: S.() -> S) {
        _state.update(block)
    }

    override fun CoroutineScope.emitEvent(event: E) {
        launch {
            _events.send(event)
        }
    }

    override suspend fun emitEvent(event: E) {
        _events.trySend(event)
    }
}
