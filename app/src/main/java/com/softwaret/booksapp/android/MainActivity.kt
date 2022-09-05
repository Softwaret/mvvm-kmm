package com.softwaret.booksapp.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softwaret.booksapp.android.books.ui.BooksScreen
import com.softwaret.booksapp.books.vm.BooksViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "books")
            {
                composable(
                    route = "books"
                ) {
                    BooksScreen(
                        viewModel { BooksViewModel(createSavedStateHandle()) }
                    )
                }
            }
        }
    }
}
