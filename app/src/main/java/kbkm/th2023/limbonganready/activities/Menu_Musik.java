package kbkm.th2023.limbonganready.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.gambangan.Alat_Musik1;
import kbkm.th2023.limbonganready.gambus.GambusInangInang;
import kbkm.th2023.limbonganready.hadra.Hadra;
import kbkm.th2023.limbonganready.lesungketintong.LesungKetintong;

public class Menu_Musik extends AppCompatActivity {

    private Button buttonGambangan,btLesung,btGambus,btHadra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_musik);

        buttonGambangan = findViewById(R.id.bt_gambangan);
        btLesung = findViewById(R.id.bt_lesung);
        btGambus = findViewById(R.id.bt_gambus);
        btHadra = findViewById(R.id.bt_hadra);


        buttonGambangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Musik.this, Alat_Musik1.class);
                startActivity(intent);
            }
        });

        btLesung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Musik.this, LesungKetintong.class);
                startActivity(intent);
            }
        } );

        btGambus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Musik.this, GambusInangInang.class);
                startActivity(intent);
            }
        });

        btHadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Musik.this, Hadra.class);
                startActivity(intent);
            }
        });
    }

    public void TtgDesa(View view) {
        startActivity(new Intent(this, Tentang_Desa.class));
    }
}