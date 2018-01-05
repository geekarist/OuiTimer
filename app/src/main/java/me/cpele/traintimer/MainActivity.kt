package me.cpele.traintimer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_rv)
        val adapter = TimerAdapter()
        adapter.add(TimerItem(
                GregorianCalendar(2018, Calendar.FEBRUARY, 5, 13, 42, 23).time,
                "Gare de Lyon",
                GregorianCalendar(2018, Calendar.FEBRUARY, 5, 17, 41, 59).time,
                "Dax"
        ))
        adapter.add(TimerItem(
                GregorianCalendar(2018, Calendar.APRIL, 23, 12, 24, 16).time,
                "Gare d'Austerlitz",
                GregorianCalendar(2018, Calendar.APRIL, 23, 15, 22, 19).time,
                "Montbard"
        ))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
