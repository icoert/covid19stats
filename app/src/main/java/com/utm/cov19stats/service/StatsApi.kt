package com.utm.cov19stats.service

import com.utm.cov19stats.models.Country
import com.utm.cov19stats.models.Stat
import com.utm.cov19stats.models.WorldTotalStats
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import org.threeten.bp.LocalDateTime

interface StatsApi {
    @GET("world/total")
    suspend fun getWorldTotalStats() : WorldTotalStats

    @GET("country/{country}/status/{status}")
    suspend fun getStats(@Path("country") country: String,
                         @Path("status") status: String?,
                         @Query("from") dateFrom: LocalDateTime?,
                         @Query("to") dateTo: LocalDateTime?) : List<Stat>

    @GET("countries")
    suspend fun getCountries() : List<Country>
}
