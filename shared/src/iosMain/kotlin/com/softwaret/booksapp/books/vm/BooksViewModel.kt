package com.softwaret.booksapp.books.vm

import com.softwaret.booksapp.useCaseComponent
import com.softwaret.booksapp.util.CloseableCoroutineScope
import com.softwaret.booksapp.util.IosParamsHolder
import com.softwaret.mvvvm.StatefulConfig

fun BooksViewModel(
    scope: CloseableCoroutineScope,
    paramsHolder: IosParamsHolder
) = BooksViewModel(
    statefulConfig = StatefulConfig(
        paramsHolder = paramsHolder,
        scope = scope
    ),
    getBooksUseCase = useCaseComponent.getBooksUseCase
)