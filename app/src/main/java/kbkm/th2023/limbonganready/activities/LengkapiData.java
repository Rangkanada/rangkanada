package kbkm.th2023.limbonganready.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import kbkm.th2023.limbonganready.MainActivity;
import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LengkapiData extends AppCompatActivity {
    private EditText txtnamalengkap, txtalamat, txtnotelpon;
    private Button tombolLengkapi;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private String JenisKelamin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lengkapi_data);

        txtnamalengkap = findViewById(R.id.namalengkap);
        txtalamat = findViewById(R.id.alamat);
        txtnotelpon = findViewById(R.id.notelepon);
        tombolLengkapi = findViewById(R.id.LengkapiData);

        preferenceManager = new PreferenceManager(this);
        apiService = RetrofitClient.getClient().create(ApiService.class);

        Spinner spinner = findViewById(R.id.jeniskelamin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                JenisKelamin = selectedItem;
                Toast.makeText(LengkapiData.this, "Jenis Kelamin: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        tombolLengkapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode untuk mengonsumsi API
                tambahData();
            }
        });
    }

    // Metode untuk mengonsumsi API
    private void tambahData() {
        // Ambil data dari EditText
        String namalengkap = txtnamalengkap.getText().toString().trim();
        String alamat = txtalamat.getText().toString().trim();
        String notelepon = txtnotelpon.getText().toString().trim();
        int userId = preferenceManager.getUserId(); // userId diambil di sini

        // Panggil metode tambahUserInfo dengan parameter yang sesuai
        Call<Void> call = apiService.tambahUserInfo(
                userId, // user_id
                namalengkap, // nama
                alamat, // alamat
                JenisKelamin, // jenis_kelamin
                notelepon // no_telepon
        );

        // Lakukan panggilan secara asynchronous
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Berhasil melakukan request
                    Toast.makeText(LengkapiData.this, "Berhasil Melengkapi Data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LengkapiData.this, MainActivity.class);
// Menambahkan flag untuk membersihkan tugas dan membuat MainActivity sebagai tugas baru
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
// Memulai aktivitas MainActivity
                    startActivity(intent);
// Menutup aktivitas saat ini (LengkapiData)
                    finish();
                } else {
                    // Gagal melakukan request
                    Toast.makeText(LengkapiData.this, "Gagal melakukan request", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Terjadi kesalahan dalam melakukan request
                Log.e("LengkapiData", "Terjadi kesalahan: " + t.getMessage());
            }
        });
    }
}
