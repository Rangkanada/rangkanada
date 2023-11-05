package kbkm.th2023.limbonganready.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import kbkm.th2023.limbonganready.R;

public class Forum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
    }

    public void Finish(View view) {
        onBackPressed();
    }

}