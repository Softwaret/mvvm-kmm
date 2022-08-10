package com.softwaret.mvvvm

interface ViewModelFactory<T : ViewModel> {

    fun create(): T
}