package kbkm.th2023.limbonganready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.ButtonMasuk);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        });
    }

    public void openSignouPage(View view) {
        startActivity(new Intent(this,Register.class));
    }
}