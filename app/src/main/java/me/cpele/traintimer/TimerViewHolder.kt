package me.cpele.traintimer

import android.support.v7.widget.RecyclerView
import android.view.View

class TimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: TimerItem) {
        val timerView = itemView as TrainTimerView

        timerView.setDepartureDateTime(item.departureDateTime)
        timerView.setDepartureStation(item.departureStation)
        timerView.setArrivalDateTime(item.arrivalDateTime)
        timerView.setArrivalStation(item.arrivalStation)
    }
}
