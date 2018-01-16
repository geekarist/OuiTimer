package me.cpele.traintimer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import java.util.*

class CircularProgressView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var dayOfMonth: Int
    private var strMonth: String

    var departureDatetime: Date
    var arrivalDateTime: Date

    private var paint: Paint

    init {

        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        val longDepartureDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_departure_datetime, 0).toLong()
        val longArrivalDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_arrival_datetime, 0).toLong()
        styledAttrs.recycle()

        departureDatetime = Date(longDepartureDatetime)
        arrivalDateTime = Date(longArrivalDatetime)

        dayOfMonth = 26
        strMonth = "oct"
        
        paint = Paint()
        paint.color = ContextCompat.getColor(context, android.R.color.black)
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = context.resources.getDimension(R.dimen.abc_text_size_medium_material);
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw day of month
        canvas?.drawText(dayOfMonth.toString(), canvas.width / 2f, canvas.height / 2f, paint)
        // Draw month
        // Draw circular background
    }
}