package kbkm.th2023.limbonganready.activities;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import kbkm.th2023.limbonganready.databinding.ActivityForumListBinding;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.fragments.ForumListFragment;
import kbkm.th2023.limbonganready.fragments.ForumSayaFragment;

public class ForumList extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityForumListBinding binding;

    private Button tombolForumList;
    private Button tombolForumSaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set content view first
        setContentView(R.layout.activity_forum_list);

        // Find buttons by ID
        tombolForumList = findViewById(R.id.tombolForumList);
        tombolForumSaya = findViewById(R.id.tombolForumSaya);

        // Set onClickListener for tombolForumList
        tombolForumList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background color of tombolForumList and tombolForumSaya
                tombolForumList.setBackgroundColor(Color.parseColor("#7B3F23"));
                tombolForumList.setTextColor(Color.WHITE);
                tombolForumSaya.setBackgroundColor(Color.parseColor("#E6C7C7"));
                tombolForumSaya.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, new ForumListFragment())
                        .commit();


            }
        });

        // Set onClickListener for tombolForumSaya
        tombolForumSaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Change background color of tombolForumSaya and tombolForumList
                tombolForumSaya.setBackgroundColor(Color.parseColor("#7B3F23"));
                tombolForumSaya.setTextColor(Color.WHITE);
                tombolForumList.setBackgroundColor(Color.parseColor("#E6C7C7"));
                tombolForumList.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, new ForumSayaFragment())
                        .commit();
            }
        });

        if (findViewById(R.id.fragmentView) != null) {
            // If being restored from a previous state, don't do anything or else you could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ForumListFragment forumListFragment = new ForumListFragment();

            ForumSayaFragment forumSayaFragment = new ForumSayaFragment();

            // Add the fragment to the 'fragmentContainerView2' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentView, forumListFragment).commit();
        }
    }

    public void Finish(View view) {
        onBackPressed();
    }
}