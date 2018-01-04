package me.cpele.traintimer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

class TimerAdapter extends RecyclerView.Adapter<TimerViewHolder> {

    @NonNull
    private ArrayList<TimerItem> mItems = new ArrayList<>();

    @Override
    public TimerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_item_train_timer, parent, false);
        return new TimerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimerViewHolder holder, int position) {
        TimerItem item = mItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void add(TimerItem timerItem) {
        mItems.add(timerItem);
    }
}
