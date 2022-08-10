package com.softwaret.booksapp.books.vm

import com.softwaret.api.ApiClient
import com.softwaret.booksapp.books.service.BooksApiService
import com.softwaret.booksapp.books.usecase.GetBooksUseCase
import com.softwaret.mvvvm.ViewModelFactory

abstract class BaseBooksViewModelFactory : ViewModelFactory<BooksViewModel> {

    protected val getBooksUseCase: GetBooksUseCase = GetBooksUseCase(
        BooksApiService(
            apiClient = ApiClient(
                basePath = "https://wolnelektury.pl/api/",
                baseUrlParameters = emptyMap()
            )
        )
    )
}

expect class BooksViewModelFactory : BaseBooksViewModelFactory