package kbkm.th2023.limbonganready.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import kbkm.th2023.limbonganready.model.EventModel;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.recyclerview.EventAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Event extends AppCompatActivity {
    PreferenceManager preferenceManager;
    ApiService apiService;
    private Context mContext;

    private Button buttonEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mContext = this;
        preferenceManager = new PreferenceManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerEvent);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String userToken = preferenceManager.getUserToken();
        apiService = RetrofitClient.getClient().create(ApiService.class);

        // Mendapatkan token Authorization dari mana pun Anda menyimpannya
        String token = "Bearer " + userToken; // Ganti dengan token yang sesuai

        // Memanggil metode getEvent() dari ApiService dengan token sebagai header
        Call<List<EventModel>> call = apiService.getEvent(token);

        // Mengirimkan permintaan secara asynchronous
        call.enqueue(new Callback<List<EventModel>>() { // Menggunakan List<EventModel> sebagai tipe respons
            @Override
            public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                // Tangani respons dari server
                if (response.isSuccessful()) {
                    // Respons berhasil
                    List<EventModel> eventList = response.body();
                    if (eventList != null) {
                        int length = eventList.size();
                        String toastMessage = "Panjang list: " + length;
                        Toast.makeText(Event.this, toastMessage, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Event.this, "List event kosong atau null.", Toast.LENGTH_SHORT).show();
                    }

                    EventAdapter adapter = new EventAdapter(eventList);
                    recyclerView.setAdapter(adapter);



                    // Iterasi melalui setiap objek EventModel dalam list
//                    for (EventModel eventk : eventList) {
//                        // Menampilkan atribut-atribut dari setiap objek EventModel menggunakan Toast
//                        Toast.makeText(Event.this, "Nama Event: " + eventk.getNama_event(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Event.this, "Deskripsi: " + eventk.getDeskripsi(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Event.this, "Tanggal: " + eventk.getTanggal(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Event.this, "Lokasi: " + eventk.getLokasi(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Event.this, "Image: " + eventk.getImage(), Toast.LENGTH_SHORT).show();
//
//                        Toast.makeText(Event.this, "Created At: " + eventk.getCreated_at(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(Event.this, "Updated At: " + eventk.getUpdated_at(), Toast.LENGTH_SHORT).show();
//                    }
                } else {
                    String errorMessage = "Terjadi kesalahan: " + response.message();
                    Toast.makeText(Event.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EventModel>> call, Throwable t) {
                Toast.makeText(Event.this, "Gagal melakukan permintaan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



//        buttonEv = findViewById(R.id.btEv);
//
//        buttonEv.setOnClickListener(v -> {
//            // Mengarahkan pengguna ke aktivitas Sketchfab
//            Intent intent = new Intent(Event.this, DetailEvent.class);
//            startActivity(intent);
//        });



    }
    public void Finish(View view) {
        onBackPressed();
    }

}