package com.example.baseapplication

import android.app.Application
import com.example.core.data.di.dataModule
import com.smb.ft_home.data.di.sampleDataModule
import com.smb.ft_home.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@BaseApplication)
            modules(listOf(presentationModule, dataModule, sampleDataModule))
        }
    }
}