package me.cpele.traintimer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import java.util.*

class CircularProgressView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var dayOfMonth: Int
    private var strMonth: String

    var departureDatetime: Date
    var arrivalDateTime: Date

    private val displayMetrics: DisplayMetrics by lazy {
        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics
    }

    private val paintText: Paint by lazy {
        val paint = Paint()
        paint.color = ContextCompat.getColor(context, android.R.color.black)
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12f, displayMetrics)
        paint
    }

    private val paintCircle: Paint by lazy {
        val paint = Paint()
        paint.color = ContextCompat.getColor(context, android.R.color.darker_gray)
        paint.style = Paint.Style.STROKE
        paint
    }

    init {

        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        val longDepartureDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_departure_datetime, 0).toLong()
        val longArrivalDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_arrival_datetime, 0).toLong()
        styledAttrs.recycle()

        departureDatetime = Date(longDepartureDatetime)
        arrivalDateTime = Date(longArrivalDatetime)

        dayOfMonth = 26
        strMonth = "oct"
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw day of month
        canvas?.drawText(dayOfMonth.toString(), canvas.width / 2f, canvas.height / 2f, paintText)
        // Draw month
        // Draw circular background
        canvas?.drawCircle(canvas.width / 2f, canvas.height / 2f, canvas.height / 2f, paintCircle)
    }
}