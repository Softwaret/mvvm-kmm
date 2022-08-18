package com.softwaret.booksapp.books.vm

import com.softwaret.booksapp.util.CloseableCoroutineScope
import com.softwaret.booksapp.util.IosParamsHolder
import com.softwaret.mvvvm.StatefulConfig

actual class BooksViewModelFactory(
    private val scope: CloseableCoroutineScope,
    private val paramsHolder: IosParamsHolder
) : BaseBooksViewModelFactory() {

    override fun create() = BooksViewModel(
        statefulConfig = StatefulConfig(
            paramsHolder = paramsHolder,
            scope = scope
        ),
        getBooksUseCase = getBooksUseCase
    )
}