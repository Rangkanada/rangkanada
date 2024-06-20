package kbkm.th2023.limbonganready.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;

import kbkm.th2023.limbonganready.ViewModel.KoleksiForumViewModel;
import kbkm.th2023.limbonganready.ViewModel.KoleksiForumViewModelFactory;

import kbkm.th2023.limbonganready.recyclerview.ForumKoleksiAdapter;

public class KoleksiForumFragment extends Fragment {
    private KoleksiForumViewModel koleksiForumViewModel;
    private ForumKoleksiAdapter adapter;
    private static final String TAG = "KoleksiEventFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_koleksi_forum, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerKoleksiForum);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize adapter with an empty list
        adapter = new ForumKoleksiAdapter(requireContext() ,new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // Use ViewModelProvider with the custom factory
        KoleksiForumViewModelFactory factory = new KoleksiForumViewModelFactory(requireContext());
        koleksiForumViewModel = new ViewModelProvider(this, factory).get(KoleksiForumViewModel.class);

        // Observe the LiveData from the ViewModel and update UI
        koleksiForumViewModel.getKoleksiForum().observe(getViewLifecycleOwner(), eventDetails -> {
            // Update your RecyclerView or other UI elements here
            adapter.setEventList(eventDetails);
        });
        return view;
    }
    public void onItemDeleted() {
        Log.d(TAG, "onItemDeleted called");
        refreshRecyclerView();
    }
    private void refreshRecyclerView() {
        Log.d(TAG, "refreshRecyclerView called");
        koleksiForumViewModel.loadKoleksiEvent(); // Reload data
        // Lakukan refresh RecyclerView
        // Misalnya, jika menggunakan ViewModel, dapat memperbarui LiveData di ViewModel

        // No need to observe again, just update the RecyclerView through the adapter
//            adapter.notifyDataSetChanged(); // Or use adapter.setEventList() if necessary


    }
}