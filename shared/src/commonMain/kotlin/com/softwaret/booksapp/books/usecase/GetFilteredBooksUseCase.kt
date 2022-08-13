package com.softwaret.booksapp.books.usecase

import com.softwaret.booksapp.books.service.BooksApiService
import com.softwaret.booksapp.books.usecase.mapper.toBook
import com.softwaret.booksapp.books.usecase.model.Book

internal class GetFilteredBooksUseCase(
    private val booksApiService: BooksApiService
) {

    suspend operator fun invoke(filter: String): List<Book> =
        if (filter.isNotBlank()) {
            booksApiService.getBooks().filter {
                it.title.lowercase().contains(filter.lowercase())
            }
        } else {
            booksApiService.getBooks()
        }.map { it.toBook() }
}