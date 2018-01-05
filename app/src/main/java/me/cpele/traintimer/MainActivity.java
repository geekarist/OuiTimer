package me.cpele.traintimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_rv);
        TimerAdapter adapter = new TimerAdapter();
        adapter.add(new TimerItem(
                1540552080,
                "Gare de Lyon",
                1540561680,
                "Dax"
        ));
        adapter.add(new TimerItem(
                1540552080,
                "Gare d'Austerlitz",
                1540561680,
                "Montbard"
        ));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
