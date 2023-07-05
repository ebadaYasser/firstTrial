package com.core.data.datasources

interface LocalDataSource {
    suspend fun addMovieToFav(capital: String)
}