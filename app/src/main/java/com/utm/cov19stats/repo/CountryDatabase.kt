package com.utm.cov19stats.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.utm.cov19stats.models.Country

@Database(entities = [Country::class], version = 1, exportSchema = false)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDao?

    companion object {
        const val DATABASE_NAME: String = "countries.db"
    }
}