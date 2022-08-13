package com.softwaret.mvvvm

import androidx.lifecycle.SavedStateHandle

class AndroidParamsHolder(
    private val savedStateHandle: SavedStateHandle
) : ParamsHolder {

    override fun <T> get(key: String): T? = savedStateHandle[key]
}
