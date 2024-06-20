package kbkm.th2023.limbonganready.activities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class DetailBerita extends AppCompatActivity {


    TextView judulBerita;
    TextView sumberBerita;
    TextView linkBerita;

    ImageView gambarBerita;
    WebView webView;

    PreferenceManager preferenceManager;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        Intent intent = getIntent();
        preferenceManager = new PreferenceManager(this);
        apiService = RetrofitClient.getClient().create(ApiService.class);
        if (intent != null) {
            String judul = intent.getStringExtra("judulberita");
            String sumber = intent.getStringExtra("sumberberita");
            String link = intent.getStringExtra("linkberita");
            String gambar = intent.getStringExtra("gambar");


            int iduser = preferenceManager.getUserId();

            String token = "Bearer " + preferenceManager.getUserToken();
            Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);



            // Inisialisasi MapView


            judulBerita = findViewById(R.id.judulBerita);
            sumberBerita = findViewById(R.id.sumberBerita);


            gambarBerita = findViewById(R.id.gambarBerita);

            webView = findViewById(R.id.webView);

            judulBerita.setText(judul);
            sumberBerita.setText(sumber);


            Glide.with(this)
                    .load("http://192.168.193.244/rangkanada/public/storage/" + gambar) // Ganti dengan method untuk mendapatkan URL gambar dari objek EventModel
                    .placeholder(R.drawable.sampel_event) // Placeholder saat gambar sedang dimuat
                    .error(R.drawable.sampel1) // Gambar yang akan ditampilkan jika terjadi kesalahan saat memuat gambar
                    .into(gambarBerita);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            // Set a WebViewClient to handle loading links within the WebView
            webView.setWebViewClient(new WebViewClient());

            // Load a URL
            webView.loadUrl(link);





            // Terima data event lainnya sesuai kebutuhan

        }

//        Tambah Koleksi


    }





}