package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual class StatefulConfig(
    val paramsHolder: ParamsHolder,
    val scope: CoroutineScope
) {

    internal var ioDispatcher: CoroutineDispatcher = Dispatchers.Default
        private set

    internal var mainDispatcher: CoroutineDispatcher = Dispatchers.Main
        private set

    constructor(
        paramsHolder: ParamsHolder,
        scope: CoroutineScope,
        ioDispatcher: CoroutineDispatcher,
        mainDispatcher: CoroutineDispatcher
    ) : this(paramsHolder, scope) {
        this.ioDispatcher = ioDispatcher
        this.mainDispatcher = mainDispatcher
    }
}

internal fun StatefulConfig.toConfig() = Config(
    paramsHolder = paramsHolder,
    scope = scope,
    ioDispatcher = ioDispatcher,
    mainDispatcher = mainDispatcher
)

