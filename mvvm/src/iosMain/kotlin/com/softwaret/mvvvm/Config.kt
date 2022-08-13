package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual class Config actual constructor(
    paramsHolder: ParamsHolder
) {

    internal lateinit var scope: CoroutineScope
        private set

    internal var ioDispatcher: CoroutineDispatcher = Dispatchers.Default
        private set

    internal var mainDispatcher: CoroutineDispatcher = Dispatchers.Main
        private set

    constructor(
        paramsHolder: ParamsHolder,
        scope: CoroutineScope
    ) : this(paramsHolder) {
        this.scope = scope
    }

    constructor(
        paramsHolder: ParamsHolder,
        scope: CoroutineScope,
        ioDispatcher: CoroutineDispatcher,
        mainDispatcher: CoroutineDispatcher
    ) : this(paramsHolder) {
        this.scope = scope
        this.ioDispatcher = ioDispatcher
        this.mainDispatcher = mainDispatcher
    }
}
