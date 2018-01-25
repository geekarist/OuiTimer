package me.cpele.traintimer

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.text.format.DateUtils.FORMAT_SHOW_TIME
import android.text.format.DateUtils.formatDateTime
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import java.util.*

class TrainTimerView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val dateView: CircularProgressView
    private val departureTimeTextView: TextView
    private val arrivalTimeTextView: TextView
    private val departureStationTextView: TextView
    private val arrivalStationTextView: TextView

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TrainTimerView)
        var departureDatetime = typedArray.getInteger(R.styleable.TrainTimerView_departure_datetime, 0).toLong()
        departureDatetime *= 1000
        val departureStation = typedArray.getString(R.styleable.TrainTimerView_departure_station)
        var arrivalDatetime = typedArray.getInteger(R.styleable.TrainTimerView_arrival_datetime, 0).toLong()
        arrivalDatetime *= 1000
        val arrivalStation = typedArray.getString(R.styleable.TrainTimerView_arrival_station)
        typedArray.recycle()

        LayoutInflater.from(getContext()).inflate(R.layout.view_train_timer, this, true)

        dateView = findViewById(R.id.timer_cp_date)
        departureTimeTextView = findViewById(R.id.timer_tv_departure_time)
        arrivalTimeTextView = findViewById(R.id.timer_tv_arrival_time)
        departureStationTextView = findViewById(R.id.timer_tv_departure_station)
        arrivalStationTextView = findViewById(R.id.timer_tv_arrival_station)

        setDepartureDateTime(departureDatetime)
        setArrivalDateTime(arrivalDatetime)
        setDepartureStation(departureStation)
        setArrivalStation(arrivalStation)
    }

    fun setArrivalStation(arrivalStation: String?) {
        arrivalStationTextView.text = arrivalStation
    }

    fun setDepartureStation(departureStation: String?) {
        departureStationTextView.text = departureStation
    }

    fun setDepartureDateTime(departureDatetime: Date) = setDepartureDateTime(departureDatetime.time)
    fun setArrivalDateTime(arrivalDatetime: Date) = setArrivalDateTime(arrivalDatetime.time)

    private fun setArrivalDateTime(arrivalDatetime: Long) {
        val strArrivalTime = formatDateTime(context, arrivalDatetime, FORMAT_SHOW_TIME)
        dateView.arrivalDateTime = Date(arrivalDatetime)
        arrivalTimeTextView.text = strArrivalTime
    }

    private fun setDepartureDateTime(departureDatetime: Long) {
        dateView.departureDatetime = Date(departureDatetime)
        val strDepartureTime = formatDateTime(context, departureDatetime, FORMAT_SHOW_TIME)
        departureTimeTextView.text = strDepartureTime
    }
}

