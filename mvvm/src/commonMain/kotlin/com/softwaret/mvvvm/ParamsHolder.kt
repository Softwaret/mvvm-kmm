package com.softwaret.mvvvm

interface ParamsHolder {

    fun <T> get(key: String): T?
}