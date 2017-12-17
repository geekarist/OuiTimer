package me.cpele.traintimer;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import static android.text.format.DateUtils.FORMAT_ABBREV_MONTH;
import static android.text.format.DateUtils.FORMAT_NO_YEAR;
import static android.text.format.DateUtils.FORMAT_SHOW_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_TIME;
import static android.text.format.DateUtils.formatDateTime;

public class TrainTimerView extends ConstraintLayout {

    public TrainTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TrainTimerView);
        long departureDatetime = typedArray.getInteger(R.styleable.TrainTimerView_departure_datetime, 0);
        departureDatetime *= 1000;
        String departureStation = typedArray.getString(R.styleable.TrainTimerView_departure_station);
        long arrivalDatetime = typedArray.getInteger(R.styleable.TrainTimerView_arrival_datetime, 0);
        arrivalDatetime *= 1000;
        String arrivalStation = typedArray.getString(R.styleable.TrainTimerView_arrival_station);
        typedArray.recycle();

        LayoutInflater.from(context)
                .inflate(R.layout.view_train_timer, this, true);

        TextView dateTextView = findViewById(R.id.timer_tv_date);
        String strDepartureDate = formatDateTime(
                context,
                departureDatetime,
                FORMAT_SHOW_DATE | FORMAT_NO_YEAR | FORMAT_ABBREV_MONTH);
        dateTextView.setText(strDepartureDate);

        TextView departureTimeTextView = findViewById(R.id.timer_tv_departure_time);
        String strDepartureTime = formatDateTime(context, departureDatetime, FORMAT_SHOW_TIME);
        departureTimeTextView.setText(strDepartureTime);

        TextView arrivalTimeTextView = findViewById(R.id.timer_tv_arrival_time);
        String strArrivalTime = formatDateTime(context, arrivalDatetime, FORMAT_SHOW_TIME);
        arrivalTimeTextView.setText(strArrivalTime);

        TextView departureStationTextView = findViewById(R.id.timer_tv_departure_station);
        departureStationTextView.setText(departureStation);

        TextView arrivalStationTextView = findViewById(R.id.timer_tv_arrival_station);
        arrivalStationTextView.setText(arrivalStation);
    }
}
