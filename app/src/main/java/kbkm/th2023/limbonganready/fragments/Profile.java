package kbkm.th2023.limbonganready.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import kbkm.th2023.limbonganready.Login;
import kbkm.th2023.limbonganready.activities.Setting;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.UserInfo;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.preferences.UserInfoManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Profile extends Fragment {
    private TextView namapengguna;
    private TextView textemail;
    private PreferenceManager preferenceManager;
    private UserInfoManager userInfoManager;

    private LinearLayout logoutPencet;

    private ApiService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        namapengguna = view.findViewById(R.id.namapengguna);
        textemail = view.findViewById(R.id.textemail);
        logoutPencet = view.findViewById(R.id.logoutPencet);
        preferenceManager = new PreferenceManager(requireContext());
        userInfoManager = new UserInfoManager(requireContext());
        apiService = RetrofitClient.getClient().create(ApiService.class);


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

        logoutPencet.setOnClickListener(view1 -> logoutUser());

        // Tambahkan pernyataan return di sini
        return view;
    }
    private void logoutUser() {
        String token = "Bearer " + preferenceManager.getUserToken(); // Assuming you have a method to get the token

        apiService.logout(token).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Clear user info
                    preferenceManager.clear();
                    userInfoManager.clear();

                    // Redirect to login or home activity
                    Intent intent = new Intent(getActivity(), Login.class); // Assuming you have a LoginActivity
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Toast.makeText(requireContext(), "Logout Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(requireContext(), "Logout failed: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(requireContext(), "Logout failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
