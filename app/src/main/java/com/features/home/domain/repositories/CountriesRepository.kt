package com.features.home.domain.repositories

import com.core.data.ResultValue
import com.core.network.models.Country

interface CountriesRepository {
    suspend fun getAllCountries(): ResultValue<Country>
}