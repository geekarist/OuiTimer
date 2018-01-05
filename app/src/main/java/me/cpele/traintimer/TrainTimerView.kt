package me.cpele.traintimer

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.text.format.DateUtils.*
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import java.util.*

class TrainTimerView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val mDateTextView: TextView
    private val mDepartureTimeTextView: TextView
    private val mArrivalTimeTextView: TextView
    private val mDepartureStationTextView: TextView
    private val mArrivalStationTextView: TextView

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

        mDateTextView = findViewById(R.id.timer_tv_date)
        mDepartureTimeTextView = findViewById(R.id.timer_tv_departure_time)
        mArrivalTimeTextView = findViewById(R.id.timer_tv_arrival_time)
        mDepartureStationTextView = findViewById(R.id.timer_tv_departure_station)
        mArrivalStationTextView = findViewById(R.id.timer_tv_arrival_station)

        setDepartureDateTime(departureDatetime)
        setArrivalDateTime(arrivalDatetime)
        setDepartureStation(departureStation)
        setArrivalStation(arrivalStation)
    }

    fun setArrivalStation(arrivalStation: String?) {
        mArrivalStationTextView.text = arrivalStation
    }

    fun setDepartureStation(departureStation: String?) {
        mDepartureStationTextView.text = departureStation
    }

    fun setDepartureDateTime(departureDatetime: Date) = setDepartureDateTime(departureDatetime.time)
    fun setArrivalDateTime(arrivalDatetime: Date) = setArrivalDateTime(arrivalDatetime.time)

    private fun setArrivalDateTime(arrivalDatetime: Long) {
        val strArrivalTime = formatDateTime(context, arrivalDatetime, FORMAT_SHOW_TIME)
        mArrivalTimeTextView.text = strArrivalTime
    }

    private fun setDepartureDateTime(departureDatetime: Long) {
        val strDepartureDate = formatDateTime(
                context,
                departureDatetime,
                FORMAT_SHOW_DATE or FORMAT_NO_YEAR or FORMAT_ABBREV_MONTH)
        mDateTextView.text = strDepartureDate
        val strDepartureTime = formatDateTime(context, departureDatetime, FORMAT_SHOW_TIME)
        mDepartureTimeTextView.text = strDepartureTime
    }
}
