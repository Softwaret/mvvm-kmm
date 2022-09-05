package com.softwaret.booksapp.di

import com.softwaret.api.ApiClient
import com.softwaret.booksapp.books.vm.BooksViewModel
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class ApiComponent(
    @get:Provides val baseUrl: String,
    @get:Provides val baseUrlParameters: Map<String, Any>
) {

    @Provides
    fun apiClient(): ApiClient = ApiClient(baseUrl, baseUrlParameters)
}