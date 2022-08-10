package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel(config: Config) {

    open fun onClear()
}

expect val ViewModel.scope: CoroutineScope

expect val ViewModel.ioDispatcher: CoroutineDispatcher

expect val ViewModel.mainDispatcher: CoroutineDispatcher
