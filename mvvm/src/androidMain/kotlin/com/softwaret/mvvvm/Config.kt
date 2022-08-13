package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class Config actual constructor(paramsHolder: ParamsHolder) {

    internal var ioDispatcher: CoroutineDispatcher = Dispatchers.IO
        private set

    internal var mainDispatcher: CoroutineDispatcher = Dispatchers.Main
        private set

    constructor(
        paramsHolder: ParamsHolder,
        ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
        mainDispatcher: CoroutineDispatcher = Dispatchers.Main
    ) : this(paramsHolder) {
        this.ioDispatcher = ioDispatcher
        this.mainDispatcher = mainDispatcher
    }
}
