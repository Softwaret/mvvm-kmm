package com.softwaret.mvvvm

import androidx.lifecycle.SavedStateHandle

class PersistentStateContainer(private val savedStateHandle: SavedStateHandle) {

    fun <State : Parcelable> putState(value: State) {
        savedStateHandle[UI_STATE_KEY] = value
    }

    fun <State : Any> uiState(): State? = savedStateHandle[UI_STATE_KEY]

    companion object {

        private const val UI_STATE_KEY = "ui_state_key_997"
    }
}