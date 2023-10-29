package kbkm.th2023.limbonganready.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kbkm.th2023.limbonganready.Login;
import kbkm.th2023.limbonganready.R;

public class Tentang_Desa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_desa);
    }

    public void AllMusik(View view) {
        startActivity(new Intent(this, Menu_Musik.class));
    }
}