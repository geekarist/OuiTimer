package me.cpele.traintimer

data class TimerItem(
        val departureDateTime: Long,
        val departureStation: String,
        val arrivalDateTime: Long,
        val arrivalStation: String
)
