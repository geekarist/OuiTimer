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

    var departureDatetime: Date
    var arrivalDateTime: Date

    private val pseudoPadding: Float by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, displayMetrics)
    }

    private val displayMetrics: DisplayMetrics by lazy {
        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics
    }

    private val contentHeight: Int by lazy {
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, displayMetrics).toInt()
    }

    private val paintCircle: Paint by lazy {
        val paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.blue_duck)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics)
        paint
    }

    init {
        val styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        val longDepartureDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_departure_datetime, 0).toLong()
        val longArrivalDatetime = styledAttrs.getInt(R.styleable.CircularProgressView_circ_arrival_datetime, 0).toLong()
        styledAttrs.recycle()

        departureDatetime = Date(longDepartureDatetime)
        arrivalDateTime = Date(longArrivalDatetime)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val measuredWidth: Int = when (MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.EXACTLY -> MeasureSpec.getSize(widthMeasureSpec)
            MeasureSpec.AT_MOST -> MeasureSpec.getSize(widthMeasureSpec)
            MeasureSpec.UNSPECIFIED -> contentHeight
            else -> throw IllegalStateException()
        }

        val measuredHeight: Int = when (MeasureSpec.getMode(heightMeasureSpec)) {
            MeasureSpec.EXACTLY -> MeasureSpec.getSize(heightMeasureSpec)
            MeasureSpec.AT_MOST -> MeasureSpec.getSize(widthMeasureSpec)
            MeasureSpec.UNSPECIFIED -> contentHeight
            else -> throw IllegalStateException()
        }

        setMeasuredDimension(MeasureSpec.getSize(measuredWidth), MeasureSpec.getSize(measuredHeight))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw day of month
        // Draw month
        // Draw circular background
        canvas?.drawCircle(
                canvas.width / 2f,
                canvas.height / 2f,
                canvas.height / 2f - pseudoPadding,
                paintCircle
        )
    }
}
