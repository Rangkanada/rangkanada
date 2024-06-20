package kbkm.th2023.limbonganready.fragments;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.ForumViewModel;
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.recyclerview.ForumAdapter;

public class ForumListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForumAdapter forumAdapter;
    private ForumViewModel forumViewModel;
    private static final String TAG = "KoleksiEventFragment";
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_list, container, false);
        // Inisialisasi ForumViewModel dengan context
        forumViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ForumViewModel(requireContext());
            }
        }).get(ForumViewModel.class);

        // Inisialisasi ForumAdapter dengan data kosong
        forumAdapter = new ForumAdapter(new ArrayList<>(), requireContext(), this);
        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerForum);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(forumAdapter);

        // Observasi data dari ForumViewModel
        forumViewModel.getForums().observe(getViewLifecycleOwner(), new Observer<List<ForumModel>>() {
            @Override
            public void onChanged(List<ForumModel> forumModels) {
                // Update adapter dengan data baru
                forumAdapter.clear();
                forumAdapter.setForumList(forumModels);
                forumAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public void refresh() {
        Log.d(TAG, "onItemDeleted called");
//        forumAdapter.clear();
//        forumViewModel.loadForums();
//        forumViewModel.getForums().observe(getViewLifecycleOwner(), new Observer<List<ForumModel>>() {
//            @Override
//            public void onChanged(List<ForumModel> forumModels) {
//                // Update adapter dengan data baru
//                forumAdapter.setForumList(forumModels);
//                forumAdapter.notifyDataSetChanged();
//            }
//        });
        // Ganti fragment dengan instance baru
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentView, new ForumListFragment());
        ft.commit();
    }

}
