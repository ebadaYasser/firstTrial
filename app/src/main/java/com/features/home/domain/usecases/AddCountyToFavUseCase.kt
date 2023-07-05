package com.features.home.domain.usecases

import com.features.home.domain.repositories.AddToFavRepository

class AddCountyToFavUseCase(private val repository: AddToFavRepository) {
    suspend operator fun invoke(capital: String) {
        repository.addCountryToFav(capital)
    }
}