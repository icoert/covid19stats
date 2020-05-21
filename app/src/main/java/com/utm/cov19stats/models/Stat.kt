package com.utm.cov19stats.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Stat (
    @SerializedName("Country")
    val country: String,
    @SerializedName("CountryCode")
    val countryCode: String,
    @SerializedName("Lat")
    val lat: String,
    @SerializedName("Lon")
    val lon: String,
    @SerializedName("Cases")
    val cases: Int,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Date")
    val date: Date

//    Example:
//    "Country": "Switzerland",
//    "CountryCode": "CH",
//    "Lat": "46.82",
//    "Lon": "8.23",
//    "Cases": 17768,
//    "Status": "confirmed",
//    "Date": "2020-04-01T00:00:00Z"
) {
    override fun toString(): String {
        return "Latest stats for your options:\n\n" +
                "Country: $country\n" +
                "CountryCode: $countryCode\n" +
                "Latitude: $lat\n" +
                "Longitude: $lon\n" +
                "Status: $status\n" +
                "Cases: $cases\n" +
                "Date: $date"
    }
}