package kbkm.th2023.limbonganready.gambus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;

import android.webkit.WebView;

import kbkm.th2023.limbonganready.R;

public class TriDGambus extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tridigambus);

        // Inisialisasi WebView
        webView = findViewById(R.id.webView);

        // Aktifkan JavaScript (opsional, tergantung pada kebutuhan)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        String sketchfabEmbedCode ="<iframe title='Alat Musik Gambangan Desa Limbongan' frameborder='0' " +
                "allowfullscreen mozallowfullscreen='true' webkitallowfullscreen='true' " +
                "allow='autoplay; fullscreen; xr-spatial-tracking' " +
                "xr-spatial-tracking execution-while-out-of-viewport " +
                "execution-while-not-rendered web-share " +
                "width='410' height='810' " +
                "src='https://sketchfab.com/models/accc4aa08d2845f795fae1f3d8c7cc9c/embed?autostart=1'></iframe>";

// Load the Sketchfab embed code into the WebView
        webView.loadData(sketchfabEmbedCode, "text/html", "utf-8");
    }
    public void Finish(View view) {
        onBackPressed();
    }
}