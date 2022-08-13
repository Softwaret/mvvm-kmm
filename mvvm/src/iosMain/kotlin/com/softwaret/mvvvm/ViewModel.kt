package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

actual abstract class ViewModel actual constructor(internal val config: Config) {

    actual open fun onClear() = Unit
}

actual val ViewModel.viewModelScope: CoroutineScope
    get() = config.scope

actual val ViewModel.ioDispatcher: CoroutineDispatcher
    get() = config.ioDispatcher

actual val ViewModel.mainDispatcher: CoroutineDispatcher
    get() = config.mainDispatcher
