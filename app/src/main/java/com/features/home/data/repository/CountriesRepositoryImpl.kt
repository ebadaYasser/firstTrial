package com.features.home.data.repository

import com.core.data.ResultValue
import com.core.data.datasources.LocalDataSource
import com.core.data.datasources.RemoteDataSource
import com.core.network.models.Country
import com.features.home.domain.repositories.CountriesRepository

class CountriesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) :
    CountriesRepository {
    override suspend fun getAllCountries(): ResultValue<Country> {
        return remoteDataSource.getAllCountries()
    }
}