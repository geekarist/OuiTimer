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

    private final TextView mDateTextView;
    private final TextView mDepartureTimeTextView;
    private final TextView mArrivalTimeTextView;
    private final TextView mDepartureStationTextView;
    private final TextView mArrivalStationTextView;

    public TrainTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TrainTimerView);
        long departureDatetime = typedArray.getInteger(R.styleable.TrainTimerView_departure_datetime, 0);
        departureDatetime *= 1000;
        String departureStation = typedArray.getString(R.styleable.TrainTimerView_departure_station);
        long arrivalDatetime = typedArray.getInteger(R.styleable.TrainTimerView_arrival_datetime, 0);
        arrivalDatetime *= 1000;
        String arrivalStation = typedArray.getString(R.styleable.TrainTimerView_arrival_station);
        typedArray.recycle();

        LayoutInflater.from(getContext())
                .inflate(R.layout.view_train_timer, this, true);

        mDateTextView = findViewById(R.id.timer_tv_date);
        mDepartureTimeTextView = findViewById(R.id.timer_tv_departure_time);
        mArrivalTimeTextView = findViewById(R.id.timer_tv_arrival_time);
        mDepartureStationTextView = findViewById(R.id.timer_tv_departure_station);
        mArrivalStationTextView = findViewById(R.id.timer_tv_arrival_station);

        setDepartureDateTime(departureDatetime);
        setArrivalDateTime(arrivalDatetime);
        setDepartureStation(departureStation);
        setArrivalStation(arrivalStation);
    }

    public void setDepartureDateTime(long departureDatetime) {
        String strDepartureDate = formatDateTime(
                getContext(),
                departureDatetime,
                FORMAT_SHOW_DATE | FORMAT_NO_YEAR | FORMAT_ABBREV_MONTH);
        mDateTextView.setText(strDepartureDate);
        String strDepartureTime = formatDateTime(getContext(), departureDatetime, FORMAT_SHOW_TIME);
        mDepartureTimeTextView.setText(strDepartureTime);
    }

    public void setArrivalStation(String arrivalStation) {
        mArrivalStationTextView.setText(arrivalStation);
    }

    public void setDepartureStation(String departureStation) {
        mDepartureStationTextView.setText(departureStation);
    }

    public void setArrivalDateTime(long arrivalDatetime) {
        String strArrivalTime = formatDateTime(getContext(), arrivalDatetime, FORMAT_SHOW_TIME);
        mArrivalTimeTextView.setText(strArrivalTime);
    }

}
