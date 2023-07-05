package com.features.home.domain.usecases

import com.core.data.ResultValue
import com.core.data.UseCaseResponse
import com.features.home.domain.repositories.CountriesRepository
import com.core.network.models.Country

class GetAllCountriesUseCase(private val countriesRepository: CountriesRepository) {
    suspend operator fun invoke(): UseCaseResponse<Country> {
        return when (val response = countriesRepository.getAllCountries()) {
            is ResultValue.Success -> UseCaseResponse.Success(response.data)
            is ResultValue.Error -> UseCaseResponse.Failure(response.message)
        }
    }

}