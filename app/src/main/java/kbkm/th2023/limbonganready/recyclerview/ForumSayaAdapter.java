package kbkm.th2023.limbonganready.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.ForumSayaViewModel;
import kbkm.th2023.limbonganready.activities.Forum;
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.model.ForumSayaModel;


public class ForumSayaAdapter extends RecyclerView.Adapter<ForumSayaAdapter.ForumViewHolder> {

    private List<ForumSayaModel> forumList;
    private Context context;

    public void clear() {
        if (forumList != null) { // Periksa apakah forumList tidak null sebelum memanggil clear()
            forumList.clear();
            notifyDataSetChanged();
        } else {
            notifyDataSetChanged();
        }
    }

    public ForumSayaAdapter(Context context, List<ForumSayaModel> forumList) {
        this.context = context;
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
        ForumSayaModel forum = forumList.get(position);
        // Bind data ke views di item_forum
        holder.bind(context, forum);
    }

    @Override
    public int getItemCount() {
        return forumList != null ? forumList.size() : 0;
    }

    public void setForumList(List<ForumSayaModel> forumList) {
        this.forumList = forumList;
    }

    static class ForumViewHolder extends RecyclerView.ViewHolder {
        private TextView forumName;
        private TextView forumDescription;
        private TextView totalAnggota;
        private Button tombolDiskusi;

        public ForumViewHolder(@NonNull View itemView) {
            super(itemView);
            forumName = itemView.findViewById(R.id.namaForum);
            forumDescription = itemView.findViewById(R.id.deskripsiForum);
            totalAnggota = itemView.findViewById(R.id.totalUser);
            tombolDiskusi = itemView.findViewById(R.id.tombolDiskusi);
        }

        public void bind(Context context, ForumSayaModel forum) {
            forumName.setText(forum.getNamaForum());
            forumDescription.setText(forum.getDeskripsi());
            totalAnggota.setText("Total Anggota : " + forum.getTotalAnggota());

            tombolDiskusi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Buat Intent untuk memulai ForumActivity
                    Intent intent = new Intent(context, Forum.class);
                    // Tambahkan ID forum ke Intent
                    intent.putExtra("forum_id", forum.getForumId());
                    intent.putExtra("nama_forum", forum.getNamaForum());
                    // Mulai aktivitas baru
                    context.startActivity(intent);
                }
            });
        }
    }
}
