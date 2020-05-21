package com.utm.cov19stats

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class AppConfig(context : Context) {
    private val preferences : SharedPreferences =
        context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)

    var lastUpdate: Date?
        get() {
            val date = preferences.getLong(LAST_UPDATE_DATE_KEY, LAST_UPDATE_DATE_DEFAULT)
            return if (date == LAST_UPDATE_DATE_DEFAULT) null
            else Date(date)
        }
        set(value) {
            val date = value?.time ?: LAST_UPDATE_DATE_DEFAULT
            preferences.edit().putLong(LAST_UPDATE_DATE_KEY, date).apply()
        }

    companion object {
        const val FILENAME = "cov19Stats-preferences"
        const val LAST_UPDATE_DATE_KEY = "last-update-date"
        const val LAST_UPDATE_DATE_DEFAULT = -1L
    }
}