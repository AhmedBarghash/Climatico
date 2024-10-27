package com.developerx.base.mvi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

/**
 *
 * @constructor
 */
interface Action

/**
 *
 * @constructor
 */
interface State

/**
 *
 * @param S
 * @param A
 * @constructor
 */
interface Reducer<S : State, A : Action> {
    fun reduce(currentState: S, action: A): S
}

/**
 * Store
 *
 * @param S
 * @param A
 * @property reducer
 * @constructor
 *
 * @param initialState
 */
class Store<S : State, A : Action>(
    initialState: S,
    private val reducer: Reducer<S, A>
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    fun dispatch(action: A) {
        val currentState = _state.value
        val newState = reducer.reduce(currentState, action)
        Timber.tag("Store: ").i("dispatch() --> newState: %s", newState)
        _state.value = newState
    }
}
