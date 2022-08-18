package com.softwaret.mvvvm

actual interface ViewModelFactory<out T : ViewModel> {

    actual fun create() : T
}
