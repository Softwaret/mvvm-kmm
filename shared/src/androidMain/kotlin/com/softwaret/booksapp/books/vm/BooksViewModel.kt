package com.softwaret.booksapp.books.vm

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.softwaret.booksapp.useCaseComponent
import com.softwaret.mvvvm.AndroidParamsHolder
import com.softwaret.mvvvm.PersistentStateContainer
import com.softwaret.mvvvm.StatefulConfig

fun BooksViewModel(
    savedStateHandle: SavedStateHandle
): BooksViewModel = BooksViewModel(
    statefulConfig = StatefulConfig(
        paramsHolder = AndroidParamsHolder(savedStateHandle),
        persistentStateContainer = PersistentStateContainer(savedStateHandle)
    ),
    getBooksUseCase = useCaseComponent.getBooksUseCase
)

actual class Preferences(context: Context) {

}