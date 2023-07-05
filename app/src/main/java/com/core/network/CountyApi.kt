package com.core.network

import com.core.network.models.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountyApi {

    @GET("all?fields=capital")
    suspend fun getAllCountries(): Response<Country>
}