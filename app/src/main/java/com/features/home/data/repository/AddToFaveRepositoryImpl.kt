package com.features.home.data.repository

import com.core.data.datasources.LocalDataSource
import com.features.home.domain.repositories.AddToFavRepository

class AddToFaveRepositoryImpl(private val localDataSource: LocalDataSource) : AddToFavRepository {
    override suspend fun addCountryToFav(capital: String) {
        localDataSource.addMovieToFav(capital)
    }
}