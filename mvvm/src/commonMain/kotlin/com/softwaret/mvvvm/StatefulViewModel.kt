package com.softwaret.mvvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

expect abstract class StatefulViewModel<State : Parcelable>(
    statefulConfig: StatefulConfig,
    initState: State
) : ViewModel {

    protected val _uiState: MutableStateFlow<State>

    val uiState: StateFlow<State>
}