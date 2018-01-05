package me.cpele.traintimer

import java.util.*

data class TimerItem(
        val departureDateTime: Date,
        val departureStation: String,
        val arrivalDateTime: Date,
        val arrivalStation: String
)
