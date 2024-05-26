package kbkm.th2023.limbonganready.gambus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import kbkm.th2023.limbonganready.R;

public class GameGambus extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_gambus);

        // Inisialisasi WebView
        webView = findViewById(R.id.gameGambus);

        // Aktifkan JavaScript (opsional, tergantung pada kebutuhan)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Muat halaman web ke dalam WebView
        webView.loadUrl("https://prototype.leolitgames.com/mustra/?layout=gambus");
    }

    public void Finish(View view) {
        onBackPressed();
    }
}