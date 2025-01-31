package com.example.cetrtaaplikacija

import android.app.Application
import com.example.cetrtaaplikacija.android.di.databaseModule
import com.example.cetrtaaplikacija.data.di.ListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CetrtaAplikacijaApp : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@CetrtaAplikacijaApp)
            modules(ListModule, databaseModule)
        }
    }
}
