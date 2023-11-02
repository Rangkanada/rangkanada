package kbkm.th2023.limbonganready.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import kbkm.th2023.limbonganready.activities.Setting;
import kbkm.th2023.limbonganready.R;


public class Profile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageButton buttonSetting = view.findViewById(R.id.bt_setting);

        buttonSetting.setOnClickListener(view1 -> {
            // Kode untuk menangani klik tombol Setting di sini
            Intent intent = new Intent(getActivity(), Setting.class);
            startActivity(intent);
        });

        // Tambahkan pernyataan return di sini
        return view;
    }
}
