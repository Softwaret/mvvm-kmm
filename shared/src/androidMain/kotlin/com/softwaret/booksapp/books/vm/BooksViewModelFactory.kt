package com.softwaret.booksapp.books.vm

import androidx.lifecycle.SavedStateHandle
import com.softwaret.mvvvm.AndroidParamsHolder
import com.softwaret.mvvvm.PersistentStateContainer
import com.softwaret.mvvvm.StatefulConfig

actual class BooksViewModelFactory(
    private val savedStateHandle: SavedStateHandle
) : BaseBooksViewModelFactory() {

    override fun create() = BooksViewModel(
        statefulConfig = StatefulConfig(
            paramsHolder = AndroidParamsHolder(savedStateHandle),
            persistentStateContainer = PersistentStateContainer(savedStateHandle)
        ),
        getBooksUseCase = getBooksUseCase
    )
}