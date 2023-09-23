package kbkm.th2023.limbonganready;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView video = (VideoView) findViewById(R.id.video1);
        MediaController media = new MediaController(this);
        Uri lokasivideo = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.opening);
        video.setVideoURI(lokasivideo);
        video.setMediaController(media);
        video.start();
        video.requestFocus();
    }
}