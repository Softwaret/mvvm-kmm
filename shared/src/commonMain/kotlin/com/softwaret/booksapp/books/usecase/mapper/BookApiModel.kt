package com.softwaret.booksapp.books.usecase.mapper

import com.softwaret.booksapp.books.service.BookApiModel
import com.softwaret.booksapp.books.usecase.model.Book


internal fun BookApiModel.toBook() =
    Book(title = title, author = author, imageUrl = simpleThumb, href = href)