package kbkm.th2023.limbonganready;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Window;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kbkm.th2023.limbonganready.fragments.Home;
import kbkm.th2023.limbonganready.fragments.Notifikasi;
import kbkm.th2023.limbonganready.fragments.Profile;
import kbkm.th2023.limbonganready.fragments.Koleksi;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
////        getSupportActionBar().hide(); //menghilangkan title bar
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
                        fragment = new Koleksi();
                        break;
                    case 4 :
                        fragment = new Profile();
                        break;
                }

                loadFragment(fragment);
            }
        });

        //set nofication count
        meowBottomNavigation.setCount(2, "10");

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
}