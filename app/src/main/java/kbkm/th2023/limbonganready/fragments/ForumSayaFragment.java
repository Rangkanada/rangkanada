package kbkm.th2023.limbonganready.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.ForumSayaBuatViewModel;
import kbkm.th2023.limbonganready.ViewModel.ForumSayaViewModel;
import kbkm.th2023.limbonganready.model.ForumSayaBuatModel;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.recyclerview.ForumSayaAdapter;
import kbkm.th2023.limbonganready.recyclerview.ForumSayaBuatAdapter;

public class ForumSayaFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView recyclerSayaBuat;
    private ForumSayaAdapter forumSayaAdapter;
    private ForumSayaBuatAdapter forumSayaBuatAdapter;
    private ForumSayaViewModel forumSayaViewModel;
    private ForumSayaBuatViewModel forumSayaBuatViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ForumSayaViewModel with the application context
        forumSayaViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()))
                .get(ForumSayaViewModel.class);

        // Initialize ForumSayaBuatViewModel with the application context
        forumSayaBuatViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()))
                .get(ForumSayaBuatViewModel.class);

        // Initialize ForumSayaAdapter with an empty data set
        forumSayaAdapter = new ForumSayaAdapter(requireContext(), new ArrayList<>());

        // Initialize ForumSayaBuatAdapter with an empty data set
        forumSayaBuatAdapter = new ForumSayaBuatAdapter(new ArrayList<>());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_saya, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerForumIkuti);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(forumSayaAdapter);

        recyclerSayaBuat = view.findViewById(R.id.recyclerSayaBuat);
        recyclerSayaBuat.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerSayaBuat.setAdapter(forumSayaBuatAdapter);

        // Observe data from ForumSayaViewModel
        forumSayaViewModel.getForums().observe(getViewLifecycleOwner(), new Observer<List<ForumSayaModel>>() {
            @Override
            public void onChanged(List<ForumSayaModel> forumModels) {
                // Update adapter with new data
                forumSayaAdapter.setForumList(forumModels);
                forumSayaAdapter.notifyDataSetChanged();
            }
        });

        forumSayaBuatViewModel.getForums().observe(getViewLifecycleOwner(), new Observer<List<ForumSayaBuatModel>>() {
            @Override
            public void onChanged(List<ForumSayaBuatModel> forumModels) {
                // Update adapter with new data
                forumSayaBuatAdapter.setForumList(forumModels);
                forumSayaBuatAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
