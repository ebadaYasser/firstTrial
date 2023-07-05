package com.features.home.domain.repositories

interface AddToFavRepository {
    suspend fun addCountryToFav(capital: String)
}