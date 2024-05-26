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



import android.widget.Toast;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.apiService.LoginResponse;
import kbkm.th2023.limbonganready.model.User;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 9001;



    private ImageButton googleSignInButton;

    private Button buttonmasuk;
    private EditText PassInput, EditTextEmail, EditTextPass,etUsername;
    private CheckBox ShowPass;


    private String getEmail, getPassword;
    private Button button;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditTextEmail = findViewById(R.id.editTextEmail);
        EditTextPass = findViewById(R.id.editTextPassword);
        buttonmasuk = findViewById(R.id.ButtonMasuk);
        PassInput = findViewById(R.id.editTextPassword);
        ShowPass = findViewById(R.id.showPass);

//        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://limbonganready-default-rtdb.firebaseio.com/");


        buttonmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EditTextEmail.getText().toString().trim();
                String password = EditTextPass.getText().toString().trim();
               System.out.println(email);



                apiService = RetrofitClient.getClient().create(ApiService.class);
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Email Atau Password Salah",Toast.LENGTH_SHORT).show();
                }else{

                    // Kirim permintaan login
                    Call<LoginResponse> call = apiService.login(email, password);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            PreferenceManager preferenceManager = new PreferenceManager(Login.this);

                            if (response.isSuccessful()) {
                                Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                // Proses tanggapan dari server jika login berhasil
                                String message = response.body().getMessageAsJson();
                                String token = response.body().getToken();
                                Toast.makeText(Login.this,  "Token Kamu : " + token, Toast.LENGTH_SHORT).show();
                                User user = response.body().getUser();

                                if (user != null) {
                                    // Gunakan data pengguna sesuai kebutuhan
                                    int userId = user.getId();
                                    String userName = user.getName();
                                    String userEmail = user.getEmail();

                                    Toast.makeText(Login.this,  "nama: " + userName, Toast.LENGTH_SHORT).show();
                                }
                                preferenceManager.saveUserId(user.getId());
                                preferenceManager.saveUserToken(token);
                                preferenceManager.saveUserName(user.getName());
                                preferenceManager.saveUserEmail(user.getEmail());
                                try {
                                    JSONObject jsonObject = new JSONObject(message);
                                    String tokenku = jsonObject.getString("token");
                                    String pesan = jsonObject.getString("message");

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish(); // Optional: menutup activity saat ini agar tidak dapat kembali ke halaman login dengan menekan tombol back



                            } else {
                                // Kesalahan jika gagal melakukan login
                                Toast.makeText(Login.this, "Gagal melakukan login", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            // Kesalahan jika gagal melakukan permintaan
                            Toast.makeText(Login.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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



    }

    public void openSignouPage(View view) {
        startActivity(new Intent(this,Register.class));
    }
}