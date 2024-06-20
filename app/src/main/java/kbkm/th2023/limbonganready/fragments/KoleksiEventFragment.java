package kbkm.th2023.limbonganready.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.KoleksiEventViewModel;
import kbkm.th2023.limbonganready.ViewModel.KoleksiEventViewModelFactory;
import kbkm.th2023.limbonganready.recyclerview.EventKoleksiAdapter;

public class KoleksiEventFragment extends Fragment implements EventKoleksiAdapter.OnItemDeletedListener {

    private KoleksiEventViewModel koleksiEventViewModel;
    private EventKoleksiAdapter adapter;
    private static final String TAG = "KoleksiEventFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_koleksi_event, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerKoleksiEvent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize adapter with an empty list
        adapter = new EventKoleksiAdapter( requireContext(),new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // Use ViewModelProvider with the custom factory
        KoleksiEventViewModelFactory factory = new KoleksiEventViewModelFactory(requireContext());
        koleksiEventViewModel = new ViewModelProvider(this, factory).get(KoleksiEventViewModel.class);

        // Observe the LiveData from the ViewModel and update UI
        koleksiEventViewModel.getKoleksiEvent().observe(getViewLifecycleOwner(), eventDetails -> {
            // Update your RecyclerView or other UI elements here
            adapter.setEventList(eventDetails);
        });

        return view;
    }

    @Override
    public void onItemDeleted() {
        Log.d(TAG, "onItemDeleted called");
        refreshRecyclerView();
    }
    private void refreshRecyclerView() {
        Log.d(TAG, "refreshRecyclerView called");
        koleksiEventViewModel.loadKoleksiEvent(); // Reload data


    }
}
