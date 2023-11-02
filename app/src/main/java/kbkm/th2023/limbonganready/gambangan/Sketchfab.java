package kbkm.th2023.limbonganready.gambangan;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.os.Bundle;

import kbkm.th2023.limbonganready.R;

public class Sketchfab extends AppCompatActivity {
    private WebView webView; // Deklarasikan variabel webView di sini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketchfab);

        // Inisialisasi WebView
        webView = findViewById(R.id.webView);

        // Aktifkan JavaScript (opsional, tergantung pada kebutuhan)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Muat halaman web ke dalam WebView
        webView.loadUrl("https://sketchfab.com/3d-models/alat-musik-tradisional-gambangan-a6f72e387ec14030abd0203cfd75cc7e");
    }
}


