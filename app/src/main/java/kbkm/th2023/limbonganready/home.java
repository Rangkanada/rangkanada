package kbkm.th2023.limbonganready;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button buttonayam = view.findViewById(R.id.buttonMusik);

        buttonayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kode untuk menangani klik button di sini
                Intent intent = new Intent(getActivity(), menu_musik.class);
                startActivity(intent);
            }
        });


        return  view;
    }
}