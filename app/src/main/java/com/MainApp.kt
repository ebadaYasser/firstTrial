package com

import android.app.Application
import com.check.firsttrial.BuildConfig
import com.core.di.appModule
import com.core.di.localDbModule
import com.core.di.networkModule
import com.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@MainApp)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(networkModule, viewModelModule, appModule)
        }
    }
}