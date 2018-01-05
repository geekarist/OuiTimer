package me.cpele.traintimer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_rv)
        val adapter = TimerAdapter()
        adapter.add(TimerItem(
                1540552080,
                "Gare de Lyon",
                1540561680,
                "Dax"
        ))
        adapter.add(TimerItem(
                1540552080,
                "Gare d'Austerlitz",
                1540561680,
                "Montbard"
        ))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
