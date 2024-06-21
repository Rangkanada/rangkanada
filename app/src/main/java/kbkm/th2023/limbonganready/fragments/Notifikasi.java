package kbkm.th2023.limbonganready.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.NotifikasiViewModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.recyclerview.NotificationAdapter;

public class Notifikasi extends Fragment {
    NotificationAdapter notificationAdapter;
    NotifikasiViewModel notifikasiViewModel;
    private PreferenceManager preferenceManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifikasi, container, false);
        preferenceManager = new PreferenceManager(requireContext());

        RecyclerView recyclerView = view.findViewById(R.id.recyclerNotif);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize adapter with an empty list
        notificationAdapter = new NotificationAdapter(new ArrayList<>(), preferenceManager);
        recyclerView.setAdapter(notificationAdapter);

        notifikasiViewModel = new ViewModelProvider(this).get(NotifikasiViewModel.class);

        // Observe the LiveData from the ViewModel and update UI
        notifikasiViewModel.getNotifikasi(preferenceManager).observe(getViewLifecycleOwner(), eventDetails -> {
            // Update your RecyclerView or other UI elements here
            notificationAdapter.setNotificationList(eventDetails);
        });

        return view;
    }
}
