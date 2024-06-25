package com.iznan.carousell.presentation.ui.section

import java.util.concurrent.TimeUnit

class TimeDelegate : TimeSectionDelegate {
    override fun Long.getRelativeTimeSpanString(): String {
        val currentTime = System.currentTimeMillis() / 1000
        val timeSpanInSeconds = currentTime - this

        val secondsInMinute = 60
        val secondsInHour = 60 * secondsInMinute
        val secondsInDay = 24 * secondsInHour
        val secondsInWeek = 7 * secondsInDay
        val secondsInMonth = 30 * secondsInDay
        val secondsInYear = 12 * secondsInMonth

        return when {
            timeSpanInSeconds < secondsInMinute -> "Just now"
            timeSpanInSeconds < secondsInHour -> "${TimeUnit.SECONDS.toMinutes(timeSpanInSeconds)} minutes ago"
            timeSpanInSeconds < secondsInDay -> "${TimeUnit.SECONDS.toHours(timeSpanInSeconds)} hours ago"
            timeSpanInSeconds < secondsInWeek -> "${TimeUnit.SECONDS.toDays(timeSpanInSeconds)} days ago"
            timeSpanInSeconds < secondsInMonth -> "${TimeUnit.SECONDS.toDays(timeSpanInSeconds) / 7} weeks ago"
            timeSpanInSeconds < secondsInYear -> "${TimeUnit.SECONDS.toDays(timeSpanInSeconds) / 30} months ago"
            else -> "${TimeUnit.SECONDS.toDays(timeSpanInSeconds) / 365} years ago"
        }
    }
}