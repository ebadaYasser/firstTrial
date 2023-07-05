package com.core.data

sealed class ResultValue<T> {

    class Success<T>(val data: T) : ResultValue<T>()

    class Error<T>(val message: String) : ResultValue<T>()

}
