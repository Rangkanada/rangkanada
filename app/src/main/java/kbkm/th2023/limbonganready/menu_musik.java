package kbkm.th2023.limbonganready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_musik extends AppCompatActivity {

    private Button buttonGambangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_musik);

        buttonGambangan = findViewById(R.id.bt_gambangan);

        buttonGambangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_musik.this, Alat_Musik1.class);
                startActivity(intent);
            }
        });
    }
}