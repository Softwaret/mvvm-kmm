package com.softwaret.mvi.android.books.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.softwaret.booksapp.books.vm.BookTile
import com.softwaret.booksapp.books.vm.BooksViewModel

@Composable
fun BooksScreen(
    viewModel: BooksViewModel
) {
    val uiState = viewModel.uiState.collectAsState()
    BooksScreen(
        bookTiles = uiState.value.bookTiles,
    )
    LaunchedEffect(Unit) { viewModel.fetch() }
}

@Composable
private fun BooksScreen(
    bookTiles: List<BookTile>
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(bookTiles) { bookTile ->
            Book(
                title = bookTile.title,
                author = bookTile.author,
                imageUrl = bookTile.imageUrl
            )
        }
    }
}