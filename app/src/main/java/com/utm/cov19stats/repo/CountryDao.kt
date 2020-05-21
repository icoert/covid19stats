package com.utm.cov19stats.repo

import androidx.room.*
import com.utm.cov19stats.models.Country

@Dao
interface CountryDao {
    @Query("SELECT * FROM Country")
    suspend fun getCountries(): List<Country>

    @Insert
    suspend fun saveCountries(categories: List<Country>)

    @Query("DELETE FROM Country")
    suspend fun deleteCountries()

    @Query("SELECT slug FROM Country WHERE country = :countryName")
    suspend fun getCountrySlug(countryName: String?): String
}