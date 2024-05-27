package kbkm.th2023.limbonganready.activities;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import kbkm.th2023.limbonganready.databinding.ActivityForumListBinding;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.fragments.ForumListFragment;

public class ForumList extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityForumListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_list);
        if (findViewById(R.id.fragmentView) != null) {
            // If being restored from a previous state, don't do anything or else you could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ForumListFragment forumListFragment = new ForumListFragment();

            // Add the fragment to the 'fragmentContainerView2' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentView, forumListFragment).commit();
        }

    }

    public void Finish(View view) {
        onBackPressed();
    }
}