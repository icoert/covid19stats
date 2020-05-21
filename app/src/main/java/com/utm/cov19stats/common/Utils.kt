package com.utm.cov19stats.common

import android.app.AlertDialog
import android.content.Context

class Utils(context: Context) {
    private val givenContext = context
    fun showDialog(statsResponse: String) {
        val dialogBuilder = AlertDialog.Builder(givenContext)
        dialogBuilder.setMessage(statsResponse)
        dialogBuilder.setPositiveButton("Done"
        ) { _, _ -> }
        val b = dialogBuilder.create()
        b.show()
    }
}