package com.utm.cov19stats.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Country")
data class Country (
    @PrimaryKey
    @SerializedName("Country")
    val country: String,
    @SerializedName("Slug")
    val slug: String,
    @SerializedName("ISO2")
    val iso: String

//    Example:
//    "Country": "Barbados",
//    "Slug": "barbados",
//    "ISO2": "BB"
)