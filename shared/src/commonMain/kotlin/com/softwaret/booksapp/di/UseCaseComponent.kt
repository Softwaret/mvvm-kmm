package com.softwaret.booksapp.di

import com.softwaret.booksapp.books.usecase.GetBooksUseCase
import me.tatarka.inject.annotations.Component

@Component
abstract class UseCaseComponent(@Component val apiComponent: ApiComponent) {

    abstract val getBooksUseCase: GetBooksUseCase
}