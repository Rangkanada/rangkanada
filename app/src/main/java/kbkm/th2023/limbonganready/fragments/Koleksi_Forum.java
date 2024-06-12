package kbkm.th2023.limbonganready.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.activities.DetailEvent;
import kbkm.th2023.limbonganready.activities.Forum;

public class Koleksi_Forum extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_koleksi, container, false);

        Button btKol = view.findViewById(R.id.btKol1);
        Button btKol2 = view.findViewById(R.id.btKol2);

        btKol.setOnClickListener(view1 -> {
            // Kode untuk menangani klik button di sini
            Intent intent = new Intent(getActivity(), DetailEvent.class);
            startActivity(intent);
        });

        btKol2.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), Forum.class);
            startActivity(intent);
        });

        return view;
    }
}