package com.softwaret.booksapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}