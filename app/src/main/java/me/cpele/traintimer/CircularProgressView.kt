package me.cpele.traintimer

import android.content.Context
import android.text.format.DateUtils
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView

class CircularProgressView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {
    var departureDatetime: Long = 0
    var arrivalDateTime: Long = 0

    init {
        val strDepartureDate = DateUtils.formatDateTime(
                context,
                departureDatetime,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_NO_YEAR or DateUtils.FORMAT_ABBREV_MONTH)
        addView(TextView(context).apply { text = strDepartureDate })
    }
}