package com.softwaret.booksapp.util

import com.softwaret.mvvvm.ParamsHolder

class IosParamsHolder(
    private val params: Map<String, Any> = emptyMap()
) : ParamsHolder {

    @Suppress("UNCHECKED_CAST")
    override fun <T> get(key: String): T? =
        (params[key] as? T)
}