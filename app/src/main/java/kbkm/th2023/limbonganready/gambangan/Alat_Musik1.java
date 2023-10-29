package kbkm.th2023.limbonganready.gambangan;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import kbkm.th2023.limbonganready.R;

public class Alat_Musik1 extends AppCompatActivity {

    private WebView webView;
    private ImageButton btnClose;

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
            //create a method to open the custom dialog on button click
            openDialog();
        });

        buttonGame.setOnClickListener(view -> {
            Intent intent = new Intent(Alat_Musik1.this, GameGambangan.class);
            startActivity(intent);
        });

//        buttonVideo.setOnClickListener(v -> {
//        Intent intent = new Intent(Alat_Musik1.this, VideoGambangan.class);
//        startActivity(intent);
//    });
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
        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NbeiKyMskuM?si=-mvJtnUSk7Kr5Swl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";


        webView.loadUrl("https://www.youtube.com/embed/NbeiKyMskuM?si=-mvJtnUSk7Kr5Swl");
        ImageButton btnClose = dialog.findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tindakan yang ingin Anda lakukan saat tombol Close ditekan
                dialog.dismiss(); // Untuk menutup pop-up dialog
            }
        });


//        btnClose.setOnClickListener(v -> {
//            dialog.dismiss(); // Menutup pop-up saat tombol ditutup
//        });

        dialog.show();

        /*LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.activity_video_gambangan,null);*/
        /*webView.loadData(*//*video*//*"https://www.youtube.com/embed/NbeiKyMskuM?si=-mvJtnUSk7Kr5Swl", "text/html", "utf-4");*/

        //set the layout
        /*dialog.setContentView(custom_dialog);*/
    }

    private void configureWebView() {
        // Aktifkan JavaScript untuk memainkan video YouTube
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
    }
}
