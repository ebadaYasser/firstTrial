package com.core.di

import android.content.Context
import androidx.room.Room
import com.core.local.MovieDataBase
import com.core.local.dao.MovieDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDbModule = module {
    single { MovieDataBase.getInstance(androidContext()).movieDao }
}

fun provideOrderDatabase(context: Context): MovieDataBase =
    Room.databaseBuilder(
        context,
        MovieDataBase::class.java,
        "movie_db"
    ).build()

fun provideMovieDao(movieDatabase: MovieDataBase): MovieDao {
    return movieDatabase.movieDao
}