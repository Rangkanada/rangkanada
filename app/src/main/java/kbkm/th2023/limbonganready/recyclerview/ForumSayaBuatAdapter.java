package kbkm.th2023.limbonganready.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.model.ForumSayaBuatModel;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;

public class ForumSayaBuatAdapter extends RecyclerView.Adapter<ForumSayaBuatAdapter.ForumViewHolder> {

    private List<ForumSayaBuatModel> forumList;
    public void clear() {
        if (forumList != null) { // Periksa apakah forumList tidak null sebelum memanggil clear()
            forumList.clear();
            notifyDataSetChanged();
        }else{
            notifyDataSetChanged();
        }
    }


    public ForumSayaBuatAdapter(List<ForumSayaBuatModel> forumList) {
        this.forumList = forumList;
    }

    @NonNull
    @Override
    public ForumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forum_saya, parent, false);
        return new ForumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumViewHolder holder, int position) {
        ForumSayaBuatModel forum = forumList.get(position);
        // Bind data ke views di item_forum
        holder.bind(forum);
    }

    @Override
    public int getItemCount() {
        return forumList != null ? forumList.size() : 0;
    }

    public void setForumList(List<ForumSayaBuatModel> forumList) {
        this.forumList = forumList;
    }

    static class ForumViewHolder extends RecyclerView.ViewHolder {
        private TextView forumName;
        private TextView forumDescription;

        private TextView totalAnggota;



        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            forumName = itemView.findViewById(R.id.namaForum);
            forumDescription = itemView.findViewById(R.id.deskripsiForum);
            totalAnggota = itemView.findViewById(R.id.totalUser);



        }

        public void bind(ForumSayaBuatModel forum) {

            forumName.setText(forum.getNama_forum());
            forumDescription.setText(forum.getDeskripsi());
            totalAnggota.setText("Total Anggota : " + forum.getUser_forum_count());
        }

    }



}