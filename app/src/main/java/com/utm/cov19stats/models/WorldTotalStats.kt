package com.utm.cov19stats.models

import com.google.gson.annotations.SerializedName

data class WorldTotalStats (
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int

//    Example:
//    "TotalConfirmed": 4420028,
//    "TotalDeaths": 302605,
//    "TotalRecovered": 1547896
) {
    override fun toString(): String {
        return "Latest World Stats\n\n" +
                "Total confirmed: $totalConfirmed\n" +
                "Total deaths: $totalDeaths\n" +
                "Total recovered: $totalRecovered"
    }
}