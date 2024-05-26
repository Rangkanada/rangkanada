package kbkm.th2023.limbonganready.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import kbkm.th2023.limbonganready.activities.Setting;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.model.UserInfo;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.preferences.UserInfoManager;


public class Profile extends Fragment {
    private TextView namapengguna;
    private TextView textemail;
    private PreferenceManager preferenceManager;
    private UserInfoManager userInfoManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        namapengguna = view.findViewById(R.id.namapengguna);
        textemail = view.findViewById(R.id.textemail);
        preferenceManager = new PreferenceManager(requireContext());
        userInfoManager = new UserInfoManager(requireContext());


            String username = userInfoManager.getNama();
            namapengguna.setText(username);


        String email = preferenceManager.getUserEmail();

        textemail.setText(email);

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
