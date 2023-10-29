package kbkm.th2023.limbonganready.gambus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;

import kbkm.th2023.limbonganready.R;

public class GambusInangInang extends AppCompatActivity {


    private MaterialCardView buttonVG;
    private WebView webView;
    private ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambus_inang_inang);

        buttonVG = findViewById(R.id.buttonVGambus);

        buttonVG.setOnClickListener(v -> {
            //create a method to open the custom dialog on button click
            openDialog();
        });


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
//        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NbeiKyMskuM?si=-mvJtnUSk7Kr5Swl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//

        webView.loadUrl("https://www.youtube.com/embed/MQIBwvpoA6w");
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