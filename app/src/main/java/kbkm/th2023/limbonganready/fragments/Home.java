package kbkm.th2023.limbonganready.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.activities.Event;
import kbkm.th2023.limbonganready.activities.Forum;
import kbkm.th2023.limbonganready.activities.Menu_Musik;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.adapters.RvEventMainAdapter;
import kbkm.th2023.limbonganready.objects.Events;

public class Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton buttonMusik = view.findViewById(R.id.buttonMusik);
        ImageButton btEvent = view.findViewById(R.id.buttonEvent);
        ImageButton btForum = view.findViewById(R.id.buttonForum);
        RecyclerView rvEvent = view.findViewById(R.id.RviewEvent);

        buttonMusik.setOnClickListener(view1 -> {
            // Kode untuk menangani klik button di sini
            Intent intent = new Intent(getActivity(), Menu_Musik.class);
            startActivity(intent);
        });

        btEvent.setOnClickListener(view2 -> {
            Intent intent = new Intent(getActivity(), Event.class);
            startActivity(intent);
        });

        btForum.setOnClickListener(view3 -> {
            Intent intent = new Intent(getActivity(), Forum.class);
            startActivity(intent);
        });

        ArrayList<Events> eventsArrayList = new ArrayList<>();

        eventsArrayList.add(new Events(R.drawable.sampel_event, "Maras taun","18 Desember 2023","Parung Alam"));
        eventsArrayList.add(new Events(R.drawable.sampel2, "Festival Budaya","9 November 2023","Auditorium Belitung Timur"));
        rvEvent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvEvent.setAdapter(new RvEventMainAdapter(eventsArrayList, getContext(), "fragment_home"));

        return view;
    }
}