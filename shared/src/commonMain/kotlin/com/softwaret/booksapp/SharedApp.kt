package com.softwaret.booksapp

import com.softwaret.booksapp.di.SharedComponentsHolder
import com.softwaret.booksapp.di.UseCaseComponent
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SharedApp {

    private var sharedComponentsHolder: SharedComponentsHolder? = null

    fun initialize(
        baseUrl: String,
        baseUrlParameters: Map<String, Any>
    ) {
        sharedComponentsHolder = SharedComponentsHolder(baseUrl, baseUrlParameters)
    }

    internal fun getSharedComponentHolder() = sharedComponentsHolder
        ?: throw IllegalStateException(
            "Usage of SharedApp must be initialized first with initialize function"
        )
}

internal val useCaseComponent: UseCaseComponent
    get() = SharedApp.getSharedComponentHolder().useCaseComponent