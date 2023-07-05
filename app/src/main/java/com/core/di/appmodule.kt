package com.core.di

import com.core.data.datasources.LocalDataSource
import com.core.data.datasources.RemoteDataSource
import com.core.local.LocalDataSourceImpl
import com.core.local.MovieDataBase
import com.core.network.remote.RemoteServiceImpl
import com.features.home.data.repository.AddToFaveRepositoryImpl
import com.features.home.data.repository.CountriesRepositoryImpl
import com.features.home.domain.repositories.AddToFavRepository
import com.features.home.domain.repositories.CountriesRepository
import com.features.home.domain.usecases.AddCountyToFavUseCase
import com.features.home.domain.usecases.GetAllCountriesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { MovieDataBase.getInstance(androidContext()).movieDao }
    factory<LocalDataSource> { LocalDataSourceImpl(get()) }
    factory<RemoteDataSource> { RemoteServiceImpl(get()) }
    factory<CountriesRepository> { CountriesRepositoryImpl(get()) }
    factory<AddToFavRepository> { AddToFaveRepositoryImpl(get()) }
    factory { GetAllCountriesUseCase(get()) }
    factory { AddCountyToFavUseCase(get()) }

}


