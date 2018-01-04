package me.cpele.traintimer;

import android.support.v7.widget.RecyclerView;
import android.view.View;

class TimerViewHolder extends RecyclerView.ViewHolder {

    public TimerViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(TimerItem item) {
        TrainTimerView timerView = (TrainTimerView) itemView;

        timerView.setDepartureDateTime(1540552080);
        timerView.setDepartureStation("Gare de Lyon");
        timerView.setArrivalDateTime(1540561680);
        timerView.setArrivalStation("Dax");
    }
}
