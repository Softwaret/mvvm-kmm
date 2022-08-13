package com.softwaret.booksapp.books.usecase

import com.softwaret.booksapp.books.service.BooksApiService
import com.softwaret.booksapp.books.usecase.mapper.toBook
import com.softwaret.booksapp.books.usecase.model.Book


class GetBooksUseCase(
    private val booksApiService: BooksApiService
) {

    suspend operator fun invoke(): List<Book> =
        booksApiService.getBooks().map { it.toBook() }
}
