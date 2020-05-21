package com.utm.cov19stats.repo

import com.utm.cov19stats.AppConfig
import com.utm.cov19stats.service.WebService
import com.utm.cov19stats.models.Country
import com.utm.cov19stats.models.Stat
import com.utm.cov19stats.models.WorldTotalStats
import java.util.*

class Repository (
    private val webService: WebService,
    private val countryDao: CountryDao,
    private val appConfig: AppConfig
)
{
    suspend fun getCountries(): List<Country> {
        val lastUpdate = appConfig.lastUpdate

        if(needsUpdate(lastUpdate)) {
            val countries = webService.getCountries()

            countryDao.deleteCountries()

            countryDao.saveCountries(countries)
            appConfig.lastUpdate = Date()

            return countries
        }

        return countryDao.getCountries()
    }

    suspend fun getWorldTotalStats(): WorldTotalStats {
        return webService.getWorldTotalStats()
    }

    suspend fun getCustomStats(country: String?, status: String?): List<Stat> {
        val slug = countryDao.getCountrySlug(country)
        print(slug)
        return webService.getStats(slug, status)
    }
    private fun Date.minusTime(millis: Long) = Date(time - millis)

    private fun needsUpdate(lastUpdate: Date?): Boolean {
        val expiryTime = 300000L // 5 min
        return lastUpdate == null || lastUpdate < Date().minusTime(expiryTime)
    }
}