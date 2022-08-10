package com.softwaret.mvvvm

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class StatefulConfig(
    val paramsHolder: ParamsHolder,
    val persistentStateContainer: PersistentStateContainer,
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
)

internal fun StatefulConfig.toConfig(): Config = Config(
    paramsHolder = paramsHolder,
    ioDispatcher = ioDispatcher,
    mainDispatcher = mainDispatcher
)