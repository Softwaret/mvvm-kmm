package com.softwaret.booksapp.android

import android.app.Application
import com.softwaret.booksapp.SharedApp

class BooksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedApp.initialize(
            baseUrl = "https://wolnelektury.pl/api/",
            baseUrlParameters = emptyMap()
        )
    }
}