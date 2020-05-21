package com.utm.cov19stats.fragments

import androidx.lifecycle.ViewModel
import com.utm.cov19stats.models.WorldTotalStats
import com.utm.cov19stats.repo.Repository

class MenuViewModel(private val repository: Repository) : ViewModel() {

    suspend fun getTotalStats(): WorldTotalStats {
        return repository.getWorldTotalStats()
    }
}
