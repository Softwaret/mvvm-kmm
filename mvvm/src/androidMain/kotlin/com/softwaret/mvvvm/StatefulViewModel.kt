package com.softwaret.mvvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual abstract class StatefulViewModel<State : Parcelable> actual constructor(
    statefulConfig: StatefulConfig,
    initState: State
) : ViewModel(statefulConfig.toConfig()) {

    protected actual val _uiState: MutableStateFlow<State> = MutableStateFlow(
        statefulConfig.persistentStateContainer.uiState() ?: initState
    )

    actual val uiState: StateFlow<State> = _uiState.onEach {
        statefulConfig.persistentStateContainer.putState(it)
    }
}