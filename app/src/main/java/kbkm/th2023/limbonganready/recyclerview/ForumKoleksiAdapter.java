package kbkm.th2023.limbonganready.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.fragments.KoleksiForumFragment;
import kbkm.th2023.limbonganready.model.EventDetail;
import kbkm.th2023.limbonganready.model.ForumResponse;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumKoleksiAdapter extends RecyclerView.Adapter<ForumKoleksiAdapter.EventViewHolder> {

    private List<ForumResponse> forumList;
    private ApiService apiService;
    private Context context;
    private PreferenceManager preferenceManager;
    KoleksiForumFragment fragment;

    public ForumKoleksiAdapter(Context context, List<ForumResponse> forumList, KoleksiForumFragment fragment) {
        this.context = context;
        this.forumList = (forumList != null) ? forumList : new ArrayList<>();
        this.apiService = RetrofitClient.getClient().create(ApiService.class);
        this.preferenceManager = new PreferenceManager(context); // Initialize PreferenceManager
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_koleksi_forum, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        ForumResponse forum = forumList.get(position);
        holder.titleTextView.setText(forum.getTitle() != null ? forum.getTitle() : "No Title");
        String jumlahAnggota = String.valueOf(forum.getForum().getUser_forum_count());
        holder.totalanggota.setText("Total Anggota : " + jumlahAnggota);
//        holder.totalanggota.setText(jumlahAnggota != null ? forum.getForum().getUser_forum_count() : "0");
        Log.d("ForumKoleksiAdapter", "User Count: " + jumlahAnggota);
        holder.deskripsi.setText(forum.getDescription() != null ? forum.getDescription() : "No Description");
        if (holder.tombolHapus != null) {
            holder.tombolHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int eventId = forum.getForumId();
                    String token = "Bearer " + preferenceManager.getUserToken();
                    int userId = preferenceManager.getUserId();
                    hapusKoleksiForum(token, eventId, userId);
                }
            });
        }
        // Initialize other views if needed
    }

    @Override
    public int getItemCount() {
        return forumList.size();
    }

    public void setEventList(List<ForumResponse> forumList) {
        this.forumList = (forumList != null) ? forumList : new ArrayList<>();
        notifyDataSetChanged();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView deskripsi;
        TextView totalanggota;

        ImageView tombolHapus;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.namaforum);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            totalanggota = itemView.findViewById(R.id.totalAnggota);
            tombolHapus = itemView.findViewById(R.id.tombolHapus);
        }
    }
    private void hapusKoleksiForum(String token, int eventId, int userId) {
        apiService.hapusKoleksiForum(token, eventId, userId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Koleksi Forum Berhasil Dihapus.", Toast.LENGTH_SHORT).show();
                    // Refresh the RecyclerView after deletion
                    fragment.onItemDeleted();

                } else {
                    Toast.makeText(context, "Gagal Menghapus Koleksi Forum.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("EventKoleksiAdapter", "Error deleting Koleksi Forum", t);
                Toast.makeText(context, "Gagal menghapus Koleksi Event.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
