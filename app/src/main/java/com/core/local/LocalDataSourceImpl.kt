package com.core.local

import com.core.data.datasources.LocalDataSource
import com.core.local.dao.MovieDao
import com.core.local.entities.MovieEntity

class LocalDataSourceImpl(private val dao: MovieDao) : LocalDataSource {
    override suspend fun addMovieToFav(capital: String) {
        dao.insertMovie(MovieEntity(capital = capital))
    }
}