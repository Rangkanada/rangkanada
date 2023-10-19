package kbkm.th2023.limbonganready.gambangan;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import kbkm.th2023.limbonganready.R;

public class Alat_Musik1 extends AppCompatActivity {

    private WebView tutorialWebView;

    private MaterialCardView buttonVideo;
    private MaterialCardView button3D;
    private MaterialCardView buttonGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat_musik1);

        buttonVideo = findViewById(R.id.buttonVideo);
        button3D = findViewById(R.id.button3D);
        buttonGame = findViewById(R.id.buttonGame);

        buttonVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Alat_Musik1.this, VideoGambangan.class);
            startActivity(intent);
        });

//        tutorialWebView = findViewById(R.id.tutorialWebView);
//
//        // Enable JavaScript untuk WebView agar video YouTube dapat dimuat.
//        WebSettings webSettings = tutorialWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        // Tampilkan video YouTube
//        //String youtubeVideoId = "NbeiKyMskuM"; // Ganti dengan ID video YouTube yang sesuai
//        String videoUrl = "https://www.youtube.com/watch?v=NbeiKyMskuM";
//        String html = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe>";
//        tutorialWebView.loadData(html, "text/html", "utf-8");
    }
}
