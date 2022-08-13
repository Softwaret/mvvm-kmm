package com.softwaret.mvi.android.books.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun Book(
    title: String,
    author: String,
    modifier: Modifier = Modifier,
    imageUrl: String = ""
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp)
                .width(64.dp),
            painter = rememberAsyncImagePainter(imageUrl), contentDescription = "Book cover"
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Top),
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = author, fontStyle = FontStyle.Italic)
        }
    }
}

@Preview
@Composable
fun BookPreview() {
    Book("Tytul", "Autor")
}