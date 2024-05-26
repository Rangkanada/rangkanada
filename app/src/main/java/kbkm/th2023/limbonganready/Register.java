package kbkm.th2023.limbonganready;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    private Button buttondaftar;
    private EditText etUsername, EditTextEmail, EditTextPass, EditTextPassConfirm;
    private CheckBox ShowPass;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        EditTextEmail = findViewById(R.id.editTextEmail);
        EditTextPass = findViewById(R.id.editTextPassword);
        EditTextPassConfirm = findViewById(R.id.editTextPasswordConfirmation);
        buttondaftar = findViewById(R.id.ButtonDaftar);
        ShowPass = findViewById(R.id.showPass);

        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = EditTextEmail.getText().toString();
                String password = EditTextPass.getText().toString();
                String passwordConfirm = EditTextPassConfirm.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                } else {
                    // Mengirim data ke server untuk pendaftaran
                    registerUser(username, email, password, passwordConfirm);
                }
            }
        });

        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShowPass.isChecked()) {
                    EditTextPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    EditTextPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void registerUser(String username, String email, String password, String passwordConfirmation) {
        // Mengirim permintaan HTTP ke server menggunakan Retrofit atau HttpURLConnection
        // Contoh menggunakan Retrofit:

        apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<Void> call = apiService.daftar(username, email, password, passwordConfirmation);
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Jika registrasi berhasil
                    Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                } else {
                    // Jika terjadi kesalahan
                    if (response.errorBody() != null) {
                        try {
                            // Membaca pesan error dari respons errorBody
                            String errorBody = response.errorBody().string();
                            Toast.makeText(getApplicationContext(), "Gagal mendaftar: " + errorBody, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Jika errorBody kosong, menampilkan pesan umum
                        Toast.makeText(getApplicationContext(), "Gagal mendaftar. Silakan coba lagi.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Jika terjadi kesalahan jaringan
                Toast.makeText(getApplicationContext(), "Gagal terhubung ke server. Periksa koneksi internet Anda.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openLoginPage(View view) {
        startActivity(new Intent(this, Login.class));
    }
}
