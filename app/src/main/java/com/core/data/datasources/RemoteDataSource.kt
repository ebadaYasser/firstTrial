package com.core.data.datasources

import com.core.data.ResultValue
import com.core.network.models.Country

interface RemoteDataSource {
    suspend fun getAllCountries(): ResultValue<Country>
}