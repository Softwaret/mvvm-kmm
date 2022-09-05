package com.softwaret.booksapp.di

internal class SharedComponentsHolder(
    baseUrl: String,
    baseUrlParameters: Map<String, Any>
) {

    private val apiComponent: ApiComponent

    val useCaseComponent: UseCaseComponent

    init {
        apiComponent =
            ApiComponent::class.create(baseUrl = baseUrl, baseUrlParameters = baseUrlParameters)
        useCaseComponent = UseCaseComponent::class.create(apiComponent)
    }
}