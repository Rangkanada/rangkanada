package kbkm.th2023.limbonganready;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

import kbkm.th2023.limbonganready.R;

public class Alat_Musik1 extends AppCompatActivity {

    private WebView tutorialWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat_musik1);

        tutorialWebView = findViewById(R.id.tutorialWebView);

        // Enable JavaScript untuk WebView agar video YouTube dapat dimuat.
        WebSettings webSettings = tutorialWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Tampilkan video YouTube
        String youtubeVideoId = "VIDEO_ID_YOUTUBE"; // Ganti dengan ID video YouTube yang sesuai
        String videoUrl = "https://youtu.be/NbeiKyMskuM?si=ZfIxiwV_4HpgFsbW" + youtubeVideoId;
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe>";
        tutorialWebView.loadData(html, "text/html", "utf-8");
    }
}
