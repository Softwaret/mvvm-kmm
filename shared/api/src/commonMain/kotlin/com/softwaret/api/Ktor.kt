package com.softwaret.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@PublishedApi
internal val client: HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    install(HttpCache)
}

fun ApiClient(
    basePath: String,
    baseUrlParameters: Map<String, Any>
): ApiClient = KtorApiClient(
    basePath,
    baseUrlParameters,
    client
)

private class KtorApiClient(
    override val basePath: String,
    override val baseUrlParams: Map<String, Any>,
    private val client: HttpClient
) : ApiClient() {

    override suspend fun getText(path: String, urlParams: Map<String, Any>): String =
        client.get(urlString = basePath + path) {
            urlParams.forEach { parameter(it.key, it.value) }
        }.bodyAsText()
}

suspend inline fun <reified T> ApiClient.get(
    path: String,
    urlParams: Map<String, Any> = emptyMap()
): T = client.get(urlString = basePath + path) {
    urlParams.forEach { parameter(it.key, it.value) }
}.body()