package me.cpele.traintimer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

internal class TimerAdapter : RecyclerView.Adapter<TimerViewHolder>() {

    private val mItems = ArrayList<TimerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_item_train_timer, parent, false)
        return TimerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        val item = mItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun add(timerItem: TimerItem) {
        mItems.add(timerItem)
        notifyDataSetChanged()
    }
}
