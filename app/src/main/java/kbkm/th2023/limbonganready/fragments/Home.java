package kbkm.th2023.limbonganready.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.ViewModel.BeritaViewModel;
import kbkm.th2023.limbonganready.ViewModel.BeritaViewModelFactory;
import kbkm.th2023.limbonganready.ViewModel.EventBaruViewModel;
import kbkm.th2023.limbonganready.ViewModel.EventBaruViewModelFactory;
import kbkm.th2023.limbonganready.activities.Event;
import kbkm.th2023.limbonganready.activities.ForumList;
import kbkm.th2023.limbonganready.activities.Menu_Musik;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.adapters.RvEventMainAdapter;
import kbkm.th2023.limbonganready.model.Berita;
import kbkm.th2023.limbonganready.model.EventModel;
import kbkm.th2023.limbonganready.objects.Events;
import kbkm.th2023.limbonganready.recyclerview.BeritaAdapter;
import kbkm.th2023.limbonganready.recyclerview.EventbaruAdapter;

public class Home extends Fragment {

    private BeritaViewModel beritaViewModel;
    private BeritaAdapter beritaAdapter;

    private EventbaruAdapter eventbaruAdapter;

    private EventBaruViewModel eventBaruViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton buttonMusik = view.findViewById(R.id.buttonMusik);
        ImageButton btEvent = view.findViewById(R.id.buttonEvent);
        ImageButton btForum = view.findViewById(R.id.buttonForum);

        RecyclerView rvEvent = view.findViewById(R.id.RviewEvent);
        RecyclerView rvBerita = view.findViewById(R.id.recyclerViewBerita);

        buttonMusik.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), Menu_Musik.class);
            startActivity(intent);
        });

        btEvent.setOnClickListener(view2 -> {
            Intent intent = new Intent(getActivity(), Event.class);
            startActivity(intent);
        });

        btForum.setOnClickListener(view3 -> {
            Intent intent = new Intent(getActivity(), ForumList.class);
            startActivity(intent);
        });

        ArrayList<Events> eventsArrayList = new ArrayList<>();
        eventsArrayList.add(new Events(R.drawable.sampel_event, "Maras taun", "18 Desember 2023", "Parung Alam"));
        eventsArrayList.add(new Events(R.drawable.sampel2, "Festival Budaya", "9 November 2023", "Auditorium Belitung Timur"));

        rvEvent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        rvEvent.setAdapter(new RvEventMainAdapter(eventsArrayList, getContext(), "fragment_home"));
        eventbaruAdapter = new EventbaruAdapter(new ArrayList<>());
        rvEvent.setAdapter(eventbaruAdapter);
        EventBaruViewModelFactory eventfactory = new EventBaruViewModelFactory(getContext());
        eventBaruViewModel = new ViewModelProvider(this, eventfactory).get(EventBaruViewModel.class);
        eventBaruViewModel.getEvent().observe(getViewLifecycleOwner(), new Observer<List<EventModel>>() {
            @Override
            public void onChanged(List<EventModel> eventModels) {
                // Update adapter with new data
                eventbaruAdapter.setEventList(eventModels);
                eventbaruAdapter.notifyDataSetChanged();
            }
        });

        rvBerita.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        beritaAdapter = new BeritaAdapter(new ArrayList<>());
        rvBerita.setAdapter(beritaAdapter);
        BeritaViewModelFactory factory = new BeritaViewModelFactory(getContext());

        beritaViewModel = new ViewModelProvider(this, factory).get(BeritaViewModel.class);
        beritaViewModel.getBerita().observe(getViewLifecycleOwner(), new Observer<List<Berita>>() {
            @Override
            public void onChanged(List<Berita> beritaModels) {
                // Update adapter with new data
                beritaAdapter.beritaList(beritaModels);
                beritaAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
