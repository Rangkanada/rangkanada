package kbkm.th2023.limbonganready.activities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailEvent extends AppCompatActivity {
    TextView judulEvent;
    TextView deskripsiEvent;

    TextView tanggalEvent;

    TextView lokasiEvent;
    MapView mapView;
    ImageView imageEvent;
    Button buttonOpenMaps;
    Button buttonTambahKoleksi;
    PreferenceManager preferenceManager;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        Intent intent = getIntent();
        preferenceManager = new PreferenceManager(this);
        apiService = RetrofitClient.getClient().create(ApiService.class);
        if (intent != null) {
            String eventDeskripisi = intent.getStringExtra("event_deskripsi");
            String eventNama = intent.getStringExtra("event_nama");
            String eventTanggal = intent.getStringExtra("tanggal");
            String lokasi = intent.getStringExtra("lokasi");
            String gambar = intent.getStringExtra("gambar");
            String coordinateString = intent.getStringExtra("coordinate");
            String idpake = intent.getStringExtra("idpake");
            int id = Integer.parseInt(idpake);
            int iduser = preferenceManager.getUserId();

            String token = "Bearer " + preferenceManager.getUserToken();
            Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);



            // Inisialisasi MapView
            mapView = findViewById(R.id.map);
            mapView.setMultiTouchControls(true);
            judulEvent = findViewById(R.id.eventTitle);
            deskripsiEvent = findViewById(R.id.eventDescription);
            lokasiEvent = findViewById(R.id.eventLocation);
            tanggalEvent = findViewById(R.id.eventTime);
            imageEvent = findViewById(R.id.eventImage);
            buttonOpenMaps = findViewById(R.id.tombollokasi);
            buttonTambahKoleksi = findViewById(R.id.tambahkoleksi);

            cekKoleksi(id, iduser, token, eventNama, eventDeskripisi);
//    Ambil Koordinat
            try {
                JSONObject jsonCoordinate = new JSONObject(coordinateString);
                String latitudeString = jsonCoordinate.getString("latitude");
                String longitudeString = jsonCoordinate.getString("longitude");
                // Gunakan jsonObject sesuai kebutuhan
                Log.d(TAG, "Event Coordinates JSON: " + jsonCoordinate);
                Log.d(TAG, "latitude : " + jsonCoordinate.getString("latitude"));
                // Menetapkan pusat peta ke koordinat tertentu
                double latitude = Double.parseDouble(latitudeString);
                double longitude = Double.parseDouble(longitudeString);
                GeoPoint startPoint = new GeoPoint(latitude, longitude);
                mapView.getController().setCenter(startPoint);
                mapView.getController().setZoom(15.0);

                // Menambahkan marker pada lokasi
                Marker startMarker = new Marker(mapView);
                startMarker.setPosition(startPoint);
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                startMarker.setTitle("Lokasi Event");
                mapView.getOverlays().add(startMarker);

                buttonOpenMaps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Panggil fungsi untuk membuka Google Maps
                        openInGoogleMaps(latitude, longitude);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }


            judulEvent.setText(eventNama);
            deskripsiEvent.setText(eventDeskripisi);
            lokasiEvent.setText(lokasi);


            String dateString = eventTanggal;
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

            try {
                Date date = inputFormat.parse(dateString);
                String formattedDate = outputFormat.format(date);
                tanggalEvent.setText(formattedDate);


            } catch (ParseException e) {
                e.printStackTrace();
            }
            Glide.with(this)
                    .load("https://admin.rangkanada.com/storage/" + gambar) // Ganti dengan method untuk mendapatkan URL gambar dari objek EventModel
                    .placeholder(R.drawable.sampel_event) // Placeholder saat gambar sedang dimuat
                    .error(R.drawable.sampel1) // Gambar yang akan ditampilkan jika terjadi kesalahan saat memuat gambar
                    .into(imageEvent);





            // Terima data event lainnya sesuai kebutuhan

        }

//        Tambah Koleksi


    }



    private void openInGoogleMaps(double latitude, double longitude) {
        // Koordinat yang akan ditampilkan di Google Maps
        double latitudePake = latitude;
        double longitudePake = longitude;

        // Buat URI dengan latitude dan longitude
        String uri = "geo:" + latitudePake + "," + longitudePake;

        // Buat Intent untuk membuka Google Maps
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Periksa apakah aplikasi Google Maps terpasang
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            // Buka Google Maps
            startActivity(mapIntent);
        } else {
            // Aplikasi Google Maps tidak terpasang, beri tahu pengguna atau tangani secara alternatif
        }
    }

    private void cekKoleksi(int event_id, int user_id, String tokenpake, String namaEvent, String deskripsiEvent){
        apiService = RetrofitClient.getClient().create(ApiService.class);

        int idEvent = event_id;
        int idUs = user_id;
        String token = tokenpake;
        String nameevent = namaEvent;
        String deskripEvent = deskripsiEvent;
        Call<ResponseBody> call = apiService.getKoleksiPerEvent(token, idEvent, idUs);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responseBody = response.body().string();
                        if (responseBody != null && !responseBody.isEmpty() && !responseBody.equals("[]")) {
                            // Tangani respon sukses dari API dengan data
                            updateButtonForKoleksi();
                            buttonTambahKoleksi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Panggil fungsi untuk membuka Google Maps

                                    hapuskoleksievent(idEvent, idUs, token);

                                }
                            });

//                            Toast.makeText(DetailEvent.this, "Termasuk Koleksi: " + responseBody, Toast.LENGTH_SHORT).show();
                        } else {

                            // Body response kosong
                           updateButtonForKoleksiKeAwal();
                            buttonTambahKoleksi.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Panggil fungsi untuk membuka Google Maps

                                    tambahKoleksi(idEvent, idUs, token, namaEvent, deskripsiEvent);

                                }
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(DetailEvent.this, "Gagal memproses respons", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Tangani respon gagal dari API
                    Toast.makeText(DetailEvent.this, "Bukan Koleksi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Tangani kegagalan komunikasi dengan API
                Toast.makeText(DetailEvent.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void tambahKoleksi(int event_id, int user_id, String tokenpake, String namaEvent, String deskripsiEvent) {
        // Buat objek Event dengan data yang ingin Anda kirim

        int idEvent = event_id;
        int idUs = user_id;
        String token = tokenpake;
        String nameevent = namaEvent;
        String deskripEvent = deskripsiEvent;

        // Panggil metode API untuk menambahkan koleksi event
        Call<Void> call = apiService.tambahkoleksievent(token, idEvent, idUs, nameevent, deskripEvent);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Tangani respon sukses dari API
                    Toast.makeText(DetailEvent.this, "Berhasil Menambahkan Koleksi", Toast.LENGTH_SHORT).show();
                    updateButtonForKoleksi();
                } else {
                    // Tangani respon gagal dari API
                    Toast.makeText(DetailEvent.this, "Terjadi kesalahan saat menyimpan data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Tangani kegagalan komunikasi dengan API
                Toast.makeText(DetailEvent.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hapuskoleksievent(int event_id, int user_id, String tokenpake) {
        // Buat objek Event dengan data yang ingin Anda kirim

        int idEvent = event_id;
        int idUs = user_id;
        String token = tokenpake;


        // Panggil metode API untuk menambahkan koleksi event
        Call<Void> call = apiService.hapuskoleksievent(token, idEvent, idUs);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Tangani respon sukses dari API
                    Toast.makeText(DetailEvent.this, "Berhasil Menghapus Koleksi", Toast.LENGTH_SHORT).show();
                    updateButtonForKoleksiKeAwal();
                } else {
                    // Tangani respon gagal dari API
                    Toast.makeText(DetailEvent.this, "Terjadi kesalahan saat menghapus koleksi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Tangani kegagalan komunikasi dengan API
                Toast.makeText(DetailEvent.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateButtonForKoleksi() {
        buttonTambahKoleksi.setBackgroundColor(Color.RED);
        buttonTambahKoleksi.setTextColor(Color.WHITE);
        buttonTambahKoleksi.setText("Hapus Koleksi");
    }
    private void updateButtonForKoleksiKeAwal() {
        buttonTambahKoleksi.setBackgroundColor(Color.parseColor("#45EA60")); // Menggunakan warna merah heksadesimal
        buttonTambahKoleksi.setTextColor(Color.BLACK); // Menggunakan warna putih heksadesimal
        buttonTambahKoleksi.setText("TAMBAHKAN KOLEKSI");
    }

}