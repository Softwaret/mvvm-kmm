package com.softwaret.booksapp.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CloseableCoroutineScope : CoroutineScope {

    private val job = SupervisorJob()

    override val coroutineContext = job + Dispatchers.Main

    fun close() {
        job.cancel()
    }
}
