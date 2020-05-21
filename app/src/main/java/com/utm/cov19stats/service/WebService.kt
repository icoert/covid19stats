package com.utm.cov19stats.service

import com.google.gson.GsonBuilder
import com.utm.cov19stats.models.Country
import com.utm.cov19stats.models.Stat
import com.utm.cov19stats.models.WorldTotalStats
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.threeten.bp.LocalDateTime

class WebService () {
    private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create()
    private val statsApi : StatsApi by lazy {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(StatsApi::class.java)
    }

    suspend fun getWorldTotalStats() : WorldTotalStats = statsApi.getWorldTotalStats()

    suspend fun getStats(countrySlug: String,
                         status: String?,
                         dateFrom: LocalDateTime = LocalDateTime.now().minusMinutes(5),
                         dateTo: LocalDateTime = LocalDateTime.now()) : List<Stat> =
        statsApi.getStats(countrySlug, status, dateFrom, dateTo)

    suspend fun getCountries() : List<Country> = statsApi.getCountries()

    companion object {
        const val API_URL = "https://api.covid19api.com/"
    }
}
