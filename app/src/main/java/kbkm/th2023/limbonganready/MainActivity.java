package kbkm.th2023.limbonganready;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


import kbkm.th2023.limbonganready.activities.LengkapiData;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.fragments.Home;
import kbkm.th2023.limbonganready.fragments.Notifikasi;
import kbkm.th2023.limbonganready.fragments.Profile;
import kbkm.th2023.limbonganready.fragments.Koleksi_Forum;
import kbkm.th2023.limbonganready.gambangan.Alat_Musik1;
import kbkm.th2023.limbonganready.model.UserInfo;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.preferences.UserInfoManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PreferenceManager preferenceManager;

    private MeowBottomNavigation meowBottomNavigation;
    private boolean doubleBackToExitPressedOnce = false;
    private ApiService apiService;




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (doubleBackToExitPressedOnce) {
            finishAffinity(); // Menutup semua activity dalam stack
            System.exit(0); // Keluar dari aplikasi
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan tombol back sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000); // Timeout 2 detik untuk menekan tombol back sekali lagi
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        preferenceManager = new PreferenceManager(this);
        UserInfoManager userInfoManager = new UserInfoManager(this); // Ganti getContext() dengan konteks yang sesuai
        int userId = preferenceManager.getUserId();
        String userToken = preferenceManager.getUserToken();


        Log.d("MainActivity", "User ID: " + userId);
        Log.d("MainActivity", "User Token: " + userToken);

//        get user info
        apiService = RetrofitClient.getClient().create(ApiService.class);
        int iduser = userId; // Contoh ID
        String token = "Bearer " + userToken;

        // Panggil metode API untuk mendapatkan informasi pengguna
        Call<UserInfo> call = apiService.getUserInfo(iduser, token);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    UserInfo userInfo = response.body();

                    userInfoManager.setNama(userInfo.getNama());
                    userInfoManager.setAlamat(userInfo.getAlamat());
                    userInfoManager.setJenisKelamin(userInfo.getJenisKelamin());
                    userInfoManager.setNomorTelepon(userInfo.getNomorTelepon());

                }else{
                    Toast.makeText(MainActivity.this, "Tidak ada Data", Toast.LENGTH_SHORT).show();
                    userInfoManager.setNama(preferenceManager.getUserName());
                    Intent intent = new Intent(MainActivity.this, LengkapiData.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                // Handle error
                Toast.makeText(MainActivity.this, "Gagal memuat data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        setContentView(R.layout.activity_main);



        meowBottomNavigation = findViewById(R.id.meowBottom);

        //add item menu
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_notification));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_simpan));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_profile));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1 :
                        fragment = new Home();
                        break;
                    case 2 :
                        fragment = new Notifikasi();
                        break;
                    case 3 :
                        fragment = new Koleksi_Forum();
                        break;
                    case 4 :
                        fragment = new Profile();
                        break;
                }

                loadFragment(fragment);
            }
        });

        //set nofication count
//        meowBottomNavigation.setCount(2, "");


        //set default
        meowBottomNavigation.show(1, true);

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "You Clicked " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }

    public void Finish(View view) {
        startActivity(new Intent(this, Alat_Musik1.class));
    }
}