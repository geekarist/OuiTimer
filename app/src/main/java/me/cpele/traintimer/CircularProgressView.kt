package me.cpele.traintimer

import android.content.Context
import android.text.format.DateUtils
import android.text.format.DateUtils.*
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import java.util.*

class CircularProgressView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    var departureDatetime: Date = Date()
        set(value) {
            val flags = FORMAT_SHOW_DATE or FORMAT_NO_YEAR or FORMAT_ABBREV_MONTH
            val strDepartureDate = DateUtils.formatDateTime(context, value.time, flags)
            viewDepartureDate.text = strDepartureDate
        }

    var arrivalDateTime: Date = Date()

    private var viewDepartureDate: TextView

    init {

        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        val longDepartureDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_departure_datetime, 0).toLong()
        val longArrivalDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_arrival_datetime, 0).toLong()
        styledAttrs.recycle()

        viewDepartureDate = TextView(context)
        addView(viewDepartureDate)

        departureDatetime = Date(longDepartureDatetime)
        arrivalDateTime = Date(longArrivalDatetime)
    }
}