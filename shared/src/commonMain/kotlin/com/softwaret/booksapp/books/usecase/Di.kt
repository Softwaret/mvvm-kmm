package com.softwaret.booksapp.books.usecase

import com.softwaret.booksapp.books.service.BooksApiService
import me.tatarka.inject.annotations.Inject

@Inject
fun createGetBooksApiService(
    booksApiService: BooksApiService
) = GetBooksUseCase(booksApiService)
