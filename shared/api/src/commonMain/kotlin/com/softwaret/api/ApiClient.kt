package com.softwaret.api

abstract class ApiClient {

    @PublishedApi
    internal abstract val basePath: String

    @PublishedApi
    internal abstract val baseUrlParams: Map<String, Any>

    abstract suspend fun getText(
        path: String,
        urlParams: Map<String, Any> = emptyMap()
    ): String
}

