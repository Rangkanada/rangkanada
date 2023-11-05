package kbkm.th2023.limbonganready;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    private ImageButton googleSignInButton;

    private Button buttonmasuk;
    private EditText PassInput, EditTextEmail, EditTextPass,etUsername;
    private CheckBox ShowPass;
    private FirebaseAuth auth;
    private DatabaseReference database;
    private String getEmail, getPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditTextEmail = findViewById(R.id.editTextEmail);
        EditTextPass = findViewById(R.id.editTextPassword);
        buttonmasuk = findViewById(R.id.ButtonMasuk);
        PassInput = findViewById(R.id.editTextPassword);
        ShowPass = findViewById(R.id.showPass);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://limbonganready-default-rtdb.firebaseio.com/");


        buttonmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = EditTextEmail.getText().toString();
                String password = EditTextPass.getText().toString();

                database = FirebaseDatabase.getInstance().getReference("users");

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Username Atau Password Salah",Toast.LENGTH_SHORT).show();
                }else{
                    database.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.child(username).exists()){
                                if (snapshot.child(username).child("password").getValue(String.class).equals(password)){
                                    Toast.makeText(getApplicationContext(), "Login Berhasil",Toast.LENGTH_SHORT).show();
                                    Intent masuk = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(masuk);
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Data Belum Terdaftar",Toast.LENGTH_SHORT).show();
                            }
                        }

//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            String lowercaseUsername = username.toLowerCase(); // Mengubah username yang dimasukkan ke huruf kecil
//                            if (snapshot.child(lowercaseUsername).exists()) {
//                                String savedPassword = snapshot.child(lowercaseUsername).child("password").getValue(String.class);
//                                if (savedPassword != null && savedPassword.equals(password)) {
//                                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
//                                    Intent masuk = new Intent(getApplicationContext(), MainActivity.class);
//                                    startActivity(masuk);
//                                } else {
//                                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                Toast.makeText(getApplicationContext(), "Data Belum Terdaftar", Toast.LENGTH_SHORT).show();
//                            }
//                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });
                }
            }
        });

        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShowPass.isChecked()){
                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

//        button = findViewById(R.id.ButtonMasuk);
//
//        button.setOnClickListener(view -> {
//            Intent intent = new Intent(Login.this,MainActivity.class);
//            startActivity(intent);
//        });
    }

    public void openSignouPage(View view) {
        startActivity(new Intent(this,Register.class));
    }
}