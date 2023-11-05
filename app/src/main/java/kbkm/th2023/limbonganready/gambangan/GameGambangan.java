package kbkm.th2023.limbonganready.gambangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import kbkm.th2023.limbonganready.R;

public class GameGambangan extends AppCompatActivity {

    private MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5,mediaPlayer6,mediaPlayer7;
    private WebView webView; // Deklarasikan variabel webView di sini


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_gambangan);

        // Inisialisasi WebView
        webView = findViewById(R.id.gameGambangan);

        // Aktifkan JavaScript (opsional, tergantung pada kebutuhan)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Muat halaman web ke dalam WebView
        webView.loadUrl("https://prototype.leolitgames.com/mustra/?layout=gambangan");


//        public void Finish(View view) {
//            Intent intent = new Intent(Alat_Musik1.this, Sketchfab.class);
//            startActivity(intent);
//        }




//        // Inisialisasi MediaPlayer
//        mediaPlayer1 = MediaPlayer.create(this, R.raw.gambangan1);
//        mediaPlayer2 = MediaPlayer.create(this, R.raw.gambangan2);
//        mediaPlayer3 = MediaPlayer.create(this, R.raw.gambangan3);
//        mediaPlayer4 = MediaPlayer.create(this, R.raw.gambangan4);
//        mediaPlayer5 = MediaPlayer.create(this, R.raw.gambangan5);
//        mediaPlayer6 = MediaPlayer.create(this, R.raw.gambangan6);
//        mediaPlayer7 = MediaPlayer.create(this, R.raw.gambangan7);
//
//        // Tambahkan listener untuk event onClick
//
//        findViewById(R.id.btn_A).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                // Mainkan audio saat button disentuh
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    mediaPlayer1.start();
//                }
//                return true;
//            }
//        });
////        findViewById(R.id.btn_A).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // Mainkan audio
////                mediaPlayer1.start();
////            }
////        });
//
//        findViewById(R.id.btn_B).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer2.start();
//            }
//        });
//
//        findViewById(R.id.btn_C).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer3.start();
//            }
//        });
//        findViewById(R.id.btn_D).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer4.start();
//            }
//        });
//        findViewById(R.id.btn_E).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer5.start();
//            }
//        });
//        findViewById(R.id.btn_F).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer6.start();
//            }
//        });
//        findViewById(R.id.btn_G).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mainkan audio
//                mediaPlayer7.start();
//            }
//        });
    }

    public void Finish(View view) {
        onBackPressed();
    }
}