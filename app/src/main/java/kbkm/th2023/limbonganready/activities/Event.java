package kbkm.th2023.limbonganready.activities;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.adapters.RvEventMainAdapter;
import kbkm.th2023.limbonganready.gambangan.Alat_Musik1;
import kbkm.th2023.limbonganready.gambangan.Sketchfab;
import kbkm.th2023.limbonganready.objects.Events;

public class Event extends AppCompatActivity {

    private Button buttonEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

//        RecyclerView rvEvent = findViewById(R.id.Rv);
//
//        ArrayList<Events> eventsArrayList = new ArrayList<>();
//
//        eventsArrayList.add(new Events(R.drawable.sampel_event, "Maras taun","18 Desember 2023","Parung Alam"));
//        eventsArrayList.add(new Events(R.drawable.sampel2, "Festival Budaya","9 November 2023","Auditorium Belitung Timur"));
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        rvEvent.setLayoutManager(layoutManager);
//
//        RvEventMainAdapter adapter = new RvEventMainAdapter(eventsArrayList, this, "activity_event");
//        rvEvent.setAdapter(adapter);

        buttonEv = findViewById(R.id.btEv);

        buttonEv.setOnClickListener(v -> {
            // Mengarahkan pengguna ke aktivitas Sketchfab
            Intent intent = new Intent(Event.this, DetailEvent.class);
            startActivity(intent);
        });



    }
}