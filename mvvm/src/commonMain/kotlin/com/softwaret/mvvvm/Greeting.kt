package com.softwaret.mvvvm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}