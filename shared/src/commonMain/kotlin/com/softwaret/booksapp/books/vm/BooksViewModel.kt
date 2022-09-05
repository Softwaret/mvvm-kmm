package com.softwaret.booksapp.books.vm

import com.softwaret.booksapp.books.usecase.GetBooksUseCase
import com.softwaret.booksapp.books.usecase.model.Book
import com.softwaret.mvvvm.Parcelable
import com.softwaret.mvvvm.Parcelize
import com.softwaret.mvvvm.StatefulConfig
import com.softwaret.mvvvm.StatefulViewModel
import com.softwaret.mvvvm.ViewModel
import com.softwaret.mvvvm.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

@Parcelize
data class BooksUiState(
    val bookTiles: List<BookTile> = emptyList()
) : Parcelable

@Parcelize
data class BookTile(
    val title: String,
    val author: String,
    val imageUrl: String
) : Parcelable

class BooksViewModel internal constructor(
    private val getBooksUseCase: GetBooksUseCase,
    statefulConfig: StatefulConfig
) : StatefulViewModel<BooksUiState>(statefulConfig, BooksUiState()) {

    fun fetch() {
        viewModelScope.launch {
            val books = getBooksUseCase().map { it.toBookTile() }
            _uiState.update {
                it.copy(
                    bookTiles = books
                )
            }
        }
    }

    private fun Book.toBookTile() = BookTile(title = title, author = author, imageUrl = imageUrl)
}

expect class Preferences {

}