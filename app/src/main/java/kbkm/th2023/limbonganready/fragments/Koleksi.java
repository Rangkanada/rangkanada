package kbkm.th2023.limbonganready.fragments;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Koleksi extends Fragment {

    private static final String TAG = "KoleksiFragment";

    private Button tombolEvent;
    private Button tombolForum;

    private Button tombolHapus;

    PreferenceManager preferenceManager;
    private ApiService apiService;
    private BroadcastReceiver refreshReceiver;

    @SuppressLint("SuspiciousIndentation")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_koleksi, container, false);

        tombolEvent = view.findViewById(R.id.tombolKoleksiEvent);
        tombolForum = view.findViewById(R.id.tombolKoleksiForum);
        tombolHapus = view.findViewById(R.id.hapusKoleksi);
        preferenceManager = new PreferenceManager(requireContext());
        apiService = RetrofitClient.getClient().create(ApiService.class);


            Log.d(TAG, "Adding KoleksiEventFragment");
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentKoleksiEvent, new KoleksiEventFragment());
            transaction.commit();
        tombolForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background color of tombolForumList and tombolForumSaya
                tombolForum.setBackgroundColor(Color.parseColor("#7B3F23"));
                tombolForum.setTextColor(Color.WHITE);
                tombolEvent.setBackgroundColor(Color.parseColor("#E6C7C7"));
                tombolEvent.setTextColor(Color.BLACK);
                tombolHapus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hapusSemuaKoleksiForum();
                    }
                });
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmentKoleksiEvent, new KoleksiForumFragment())
                        .commit();


            }
        });

        // Set onClickListener for tombolForumSaya
        tombolEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background color of tombolForumSaya and tombolForumList
                tombolEvent.setBackgroundColor(Color.parseColor("#7B3F23"));
                tombolEvent.setTextColor(Color.WHITE);
                tombolForum.setBackgroundColor(Color.parseColor("#E6C7C7"));
                tombolForum.setTextColor(Color.BLACK);
                tombolHapus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hapusSemuaKoleksiEvent();
                    }
                });
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.fragmentKoleksiEvent, new KoleksiEventFragment())
                        .commit();
            }
        });

        tombolHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusSemuaKoleksiEvent();
            }
        });







        return view;
    }
    private void refreshFragmentWithDelay(long delayMillis) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            FragmentTransaction ft = getParentFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
        }, delayMillis);
    }
    private void hapusSemuaKoleksiEvent() {
        int iduser = preferenceManager.getUserId();
        String token = "Bearer " + preferenceManager.getUserToken();
        if (iduser != 0) {
            apiService.hapusSemuaKoleksiEvent(token, iduser).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "KoleksiEvent deleted successfully.");
                        Toast.makeText(getContext(), "Koleksi Event Berhasil Dihapus.", Toast.LENGTH_SHORT).show();
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.fragmentKoleksiEvent, new KoleksiEventFragment())
                                .commit();
                    } else {
                        Log.d(TAG, "Failed to delete KoleksiEvent.");
                        Toast.makeText(getContext(), "Gagal Menghapus Koleksi Event.", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e(TAG, "Error deleting KoleksiEvent", t);
                    Toast.makeText(getContext(), "Error deleting KoleksiEvent", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "User ID is null. Cannot delete KoleksiEvent.");
            Toast.makeText(getContext(), "User ID is null. Cannot delete KoleksiEvent.", Toast.LENGTH_SHORT).show();
        }
    }


    private void hapusSemuaKoleksiForum() {
        int iduser = preferenceManager.getUserId();
        String token = "Bearer " + preferenceManager.getUserToken();
        if (iduser != 0) {
            apiService.hapusSemuaKoleksiForum(token, iduser).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Koleksi Forum Berhasil Dihapus.");
                        Toast.makeText(getContext(), "Koleksi Forum Berhasil Dihapus.", Toast.LENGTH_SHORT).show();
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.fragmentKoleksiEvent, new KoleksiForumFragment())
                                .commit();
                    } else {
                        Log.d(TAG, "Failed to delete KoleksiEvent.");
                        Toast.makeText(getContext(), "Gagal Menghapus Koleksi Forum.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.e(TAG, "Error deleting KoleksiForum", t);
                    Toast.makeText(getContext(), "Gagal menghapus koleksi forum", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "User ID is null. Cannot delete KoleksiEvent.");
            Toast.makeText(getContext(), "User ID is null. Cannot delete Koleksi Forum.", Toast.LENGTH_SHORT).show();
        }
    }
}
