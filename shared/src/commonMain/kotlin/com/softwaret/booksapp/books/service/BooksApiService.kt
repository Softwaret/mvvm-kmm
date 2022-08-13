package com.softwaret.booksapp.books.service

import com.softwaret.api.ApiClient
import com.softwaret.api.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookApiModel(
    val title: String,
    val author: String,
    val href: String,
    val cover: String,
    @SerialName("simple_thumb")
    val simpleThumb: String
)

class BooksApiService(private val apiClient: ApiClient) {

    suspend fun getBooks(): List<BookApiModel> = apiClient.get(path = "books/")
}