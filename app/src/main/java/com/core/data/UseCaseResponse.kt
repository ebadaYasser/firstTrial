package com.core.data

sealed class UseCaseResponse<out T> {
    data class Success<out T>(val body: T) : UseCaseResponse<T>()

    data class Failure(val error: String) : UseCaseResponse<Nothing>()

}