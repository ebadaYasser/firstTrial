package com.core.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.core.local.dao.MovieDao
import com.core.local.entities.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 4,
    exportSchema = false
)
abstract class MovieDataBase : RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDataBase? = null

        fun getInstance(context: Context): MovieDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDataBase::class.java,
                        "my_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}