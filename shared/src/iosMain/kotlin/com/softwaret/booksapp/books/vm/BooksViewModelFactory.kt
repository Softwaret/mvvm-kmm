package com.softwaret.booksapp.books.vm

import com.softwaret.mvvvm.IosParamsHolder
import com.softwaret.mvvvm.StatefulConfig
import kotlinx.coroutines.CoroutineScope

actual class BooksViewModelFactory(
    private val scope: CoroutineScope,
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