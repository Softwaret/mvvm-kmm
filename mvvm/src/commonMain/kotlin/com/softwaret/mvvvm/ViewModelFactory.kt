package com.softwaret.mvvvm

expect interface ViewModelFactory<out T : ViewModel> {

    fun create(): T
}