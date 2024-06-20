package kbkm.th2023.limbonganready.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.fragments.KoleksiEventFragment;
import kbkm.th2023.limbonganready.model.EventDetail;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventKoleksiAdapter extends RecyclerView.Adapter<EventKoleksiAdapter.EventViewHolder> {

    private Context context;
    private List<EventDetail> eventList;
    private ApiService apiService;
    private PreferenceManager preferenceManager;
    private OnItemDeletedListener listener;
    private KoleksiEventFragment fragment;


    public interface OnItemDeletedListener {
        void onItemDeleted();
    }


    public EventKoleksiAdapter(Context context, List<EventDetail> eventList, KoleksiEventFragment fragment) {
        this.context = context;
        this.eventList = (eventList != null) ? eventList : new ArrayList<>();
        this.apiService = RetrofitClient.getClient().create(ApiService.class);
        this.preferenceManager = new PreferenceManager(context); // Initialize PreferenceManager
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_koleksi_event, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventDetail event = eventList.get(position);
        holder.titleTextView.setText(event.getTitle());
        holder.dateTextView.setText(event.getEvent().getTanggal());
        Glide.with(holder.itemView.getContext())
                .load("http://192.168.193.244/rangkanada/public/storage/" + event.getEvent().getImage())
                .placeholder(R.drawable.sampel_event)
                .error(R.drawable.sampel1)
                .into(holder.gambarEvent);

        // Set click listener for tombolHapus
        if (holder.tombolHapus != null) {
            holder.tombolHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int eventId = event.getEvent().getId();
                    String token = "Bearer " + preferenceManager.getUserToken();
                    int userId = preferenceManager.getUserId();
                    hapusKoleksiEvent(token, eventId, userId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setEventList(List<EventDetail> eventList) {
        this.eventList = (eventList != null) ? eventList : new ArrayList<>();
        notifyDataSetChanged();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
        ImageView gambarEvent;
        ImageView tombolHapus;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.namaEvent);
            dateTextView = itemView.findViewById(R.id.tanggalEvent);
            gambarEvent = itemView.findViewById(R.id.gambarEvent);
            tombolHapus = itemView.findViewById(R.id.gambarTombolHapus);
        }
    }

    private void hapusKoleksiEvent(String token, int eventId, int userId) {
        apiService.hapusKoleksiEvent(token, eventId, userId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Koleksi Event Berhasil Dihapus.", Toast.LENGTH_SHORT).show();
                    // Refresh the RecyclerView after deletion
                    fragment.onItemDeleted();

                } else {
                    Toast.makeText(context, "Gagal Menghapus Koleksi Event.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("EventKoleksiAdapter", "Error deleting Koleksi Event", t);
                Toast.makeText(context, "Gagal menghapus Koleksi Event.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refreshRecyclerView() {

        notifyDataSetChanged(); // Simply notify dataset changed
    }
}
