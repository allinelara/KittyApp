package com.allinedelara.kittyapp

import android.app.Application
import com.allinedelara.domain.usecases.di.moduleData
import com.allinedelara.domain.usecases.di.moduleDomain
import com.allinedelara.kittyapp.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            androidContext(this@Application)
            modules(module)
            modules(moduleDomain)
            modules(moduleData)
        }
    }
}