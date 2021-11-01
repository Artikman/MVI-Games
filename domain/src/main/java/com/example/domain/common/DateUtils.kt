package com.example.domain.common

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@SuppressLint("SimpleDateFormat")
object DateUtil {
    private val inputFormat = SimpleDateFormat("yyyy-MM-dd")

    fun getTimeAgo(date: String): String {
        val formattedDate: Date? = inputFormat.parse(date)
        val currentTime = Calendar.getInstance().timeInMillis
        val timeAgo = DateUtils.getRelativeTimeSpanString(
            formattedDate?.time ?: 0,
            currentTime,
            DateUtils.MINUTE_IN_MILLIS
        )
        return timeAgo.toString()
    }
}