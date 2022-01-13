package com.ndt.imagefilters.utilities

import android.app.Application
import com.ndt.imagefilters.dependencyinjection.repositoryModule
import com.ndt.imagefilters.dependencyinjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class AppConfig : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppConfig)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }
}