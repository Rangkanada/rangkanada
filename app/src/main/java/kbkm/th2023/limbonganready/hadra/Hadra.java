package kbkm.th2023.limbonganready.hadra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.gambangan.Alat_Musik1;
import kbkm.th2023.limbonganready.gambangan.GameGambangan;

public class Hadra extends AppCompatActivity {

    private MaterialCardView buttonVH,button3DL,buttonGameL;
    private WebView webView;
    private ImageButton btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadra);

        buttonVH = findViewById(R.id.buttonVHadrah);
        button3DL = findViewById(R.id.button3DL);
        buttonGameL = findViewById(R.id.buttonGameL);
        button3DL.setOnClickListener(view -> {
            Intent intent = new Intent(Hadra.this, TriDHadrah.class);
            startActivity(intent);
        });
        buttonGameL.setOnClickListener(view -> {
            Intent intent = new Intent(Hadra.this, GameHadrah.class);
            startActivity(intent);
        });
        buttonVH.setOnClickListener(v -> {
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
        }

        webView = dialog.findViewById(R.id.webView);
        configureWebView();
        webView.loadUrl("https://www.youtube.com/embed/vOmlfMwqucg");
        ImageButton btnClose = dialog.findViewById(R.id.btnClose);

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