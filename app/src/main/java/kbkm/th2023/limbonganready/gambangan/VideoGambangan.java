//package kbkm.th2023.limbonganready.gambangan;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.WindowManager;
//import android.webkit.WebChromeClient;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.ImageButton;
//
//import kbkm.th2023.limbonganready.R;
//
//public class VideoGambangan extends AppCompatActivity {
//
//    private WebView webView;
//    private ImageButton btnClose;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video_gambangan);
//
//        // Menghilangkan status bar
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        webView = findViewById(R.id.webView);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NbeiKyMskuM?si=-mvJtnUSk7Kr5Swl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
//
//        webView.loadData(video, "text/html","utf-4");
//        btnClose = findViewById(R.id.btnClose);
//        configureWebView();
//
////        // URL video YouTube yang ingin Anda tampilkan
////        String videoUrl = "https://www.youtube.com/watch?v=NbeiKyMskuM&t";
////
////        // Ubah URL video menjadi URL embed
////        String embedUrl = "https://www.youtube.com/embed/=NbeiKyMskuM&t";
////
////        // Muat video YouTube ke WebView
////        webView.loadUrl(embedUrl);
////        webView.loadUrl(videoUrl);
//
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish(); // Menutup pop-up saat tombol ditutup
//            }
//        });
//
//    }
//
//    private void configureWebView() {
//        // Aktifkan JavaScript untuk memainkan video YouTube
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.setWebChromeClient(new WebChromeClient());
//
//    }
//}