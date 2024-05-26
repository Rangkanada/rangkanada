package kbkm.th2023.limbonganready.lesungketintong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.gambus.GambusInangInang;
import kbkm.th2023.limbonganready.gambus.GameGambus;
import kbkm.th2023.limbonganready.gambus.TriDGambus;

public class LesungKetintong extends AppCompatActivity {

    private MaterialCardView buttonVL,button3DL,buttonGameL;
    private WebView webView;
    private ImageButton btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesung_ketintong);

        buttonVL = findViewById(R.id.buttonVLesong);
        button3DL = findViewById(R.id.button3DL);
        buttonGameL = findViewById(R.id.buttonGameL);
        button3DL.setOnClickListener(view -> {
            Intent intent = new Intent(LesungKetintong.this, TriDLesong.class);
            startActivity(intent);
        });
        buttonGameL.setOnClickListener(view -> {
            Intent intent = new Intent(LesungKetintong.this, GameLesong.class);
            startActivity(intent);
        });

        buttonVL.setOnClickListener(v -> {
            //create a method to open the custom dialog on button click
            openDialog();
        });
    }

    public void Finish(View view) {
        onBackPressed();
    }

    private void openDialog() {
        // Inisialisasi dialog
        Dialog dialog = new Dialog(this);
        // Mengatur tampilan kustom untuk dialog
        dialog.setContentView(R.layout.activity_video_gambangan);

        dialog.setCancelable(false);


        if (getWindow() == null) {

            dialog.show();
        }
        // Mengatur ukuran dialog
        if (getWindow() != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT; // Sesuaikan dengan lebar yang Anda inginkan
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT; // Sesuaikan dengan tinggi yang Anda inginkan
            dialog.getWindow().setAttributes(layoutParams);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        webView = dialog.findViewById(R.id.webView);
        configureWebView();
        webView.loadUrl("https://www.youtube.com/embed/2mPfvUSNlSk");
        MaterialCardView btnClose = dialog.findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tindakan yang ingin Anda lakukan saat tombol Close ditekan
                dialog.dismiss(); // Untuk menutup pop-up dialog
            }
        });

        dialog.show();
    }

    private void configureWebView() {
        // Aktifkan JavaScript untuk memainkan video YouTube
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
    }
}