package com.utm.cov19stats

import android.app.Application
import androidx.room.Room
import com.jakewharton.threetenabp.AndroidThreeTen
import com.utm.cov19stats.fragments.CustomizeViewModel
import com.utm.cov19stats.fragments.MenuViewModel
import com.utm.cov19stats.repo.CountryDatabase
import com.utm.cov19stats.repo.CountryDatabase.Companion.DATABASE_NAME
import com.utm.cov19stats.repo.Repository
import com.utm.cov19stats.service.WebService
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize dependency injection
        AndroidThreeTen.init(this);
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    private val appModule = module {
        single { Room.databaseBuilder(get(), CountryDatabase::class.java, DATABASE_NAME).build() }
        single { get<CountryDatabase>().countryDao() }
        single { AppConfig(get()) }
        single { WebService() }
        single { Repository(get(), get(), get()) }
        viewModel { MenuViewModel(get()) }
        viewModel { CustomizeViewModel(get()) }
    }
}