package com.core.network.remote

import com.core.data.ResultValue
import com.core.data.datasources.RemoteDataSource
import com.core.network.CountyApi
import com.core.network.models.Country

class RemoteServiceImpl(private val countyApi: CountyApi) : RemoteDataSource {
    override suspend fun getAllCountries(): ResultValue<Country> {
        val result = countyApi.getAllCountries()
        if (!result.isSuccessful)
            return ResultValue.Error("Error")
        else {
            result.body()?.let {
                return ResultValue.Success(it)
            } ?: run {
                return ResultValue.Error("Error")
            }
        }
    }
}