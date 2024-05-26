package kbkm.th2023.limbonganready.lesungketintong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import kbkm.th2023.limbonganready.R;

public class GameLesong extends AppCompatActivity {

    private WebView webView; // Deklarasikan variabel webView di sini


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lesong);

        // Inisialisasi WebView
        webView = findViewById(R.id.gameLesong);

        // Aktifkan JavaScript (opsional, tergantung pada kebutuhan)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Muat halaman web ke dalam WebView
        webView.loadUrl("https://prototype.leolitgames.com/mustra/?layout=lesong");
    }

    public void Finish(View view) {
        onBackPressed();
    }
}