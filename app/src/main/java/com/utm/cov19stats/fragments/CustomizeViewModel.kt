package com.utm.cov19stats.fragments

import androidx.lifecycle.ViewModel
import com.utm.cov19stats.models.Stat
import com.utm.cov19stats.repo.Repository

class CustomizeViewModel(private val repository: Repository) : ViewModel() {

    suspend fun getCountryList(): List<String?> {
        val list = repository.getCountries()
        val stringList = arrayOfNulls<String>(list.size)
        for(i in list.indices) {
            stringList[i] = list[i].country
        }
        stringList.sort()

        return stringList.toList()
    }

    suspend fun getStats(country: String, case: String): List<Stat> {
        return repository.getCustomStats(country, case)
    }
}
