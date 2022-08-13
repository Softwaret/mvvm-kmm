package com.softwaret.mvvvm

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

private typealias AndroidXViewModel = androidx.lifecycle.ViewModel

actual abstract class ViewModel actual constructor(
    internal val config: Config
) :
    AndroidXViewModel() {

    final override fun onCleared() {
        super.onCleared()
        onClear()
    }

    actual open fun onClear() = Unit
}

actual val ViewModel.viewModelScope: CoroutineScope
    get() = viewModelScope

actual val ViewModel.ioDispatcher: CoroutineDispatcher
    get() = config.ioDispatcher

actual val ViewModel.mainDispatcher: CoroutineDispatcher
    get() = config.mainDispatcher