package kbkm.th2023.limbonganready.recyclerview;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.activities.DetailEvent;
import kbkm.th2023.limbonganready.model.Berita;
import kbkm.th2023.limbonganready.model.EventModel;

public class EventbaruAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private List<EventModel> eventList;

    public EventbaruAdapter(List<EventModel> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_main, parent, false);
        return new EventViewHolder(itemView);
    }

    public void setEventList(List<EventModel> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventModel event = eventList.get(position);
        holder.judulEvent.setText(event.getNama_event());

        String dateString = event.getTanggal();
      ;

        int id = event.getId();
        String idpake = String.valueOf(id);

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

        try {
            Date date = inputFormat.parse(dateString);
            String formattedDate = outputFormat.format(date);
            holder.tanggalEvent.setText(formattedDate);
            System.out.println("Tanggal dalam format biasa: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.gmbrEvent.setImageResource(R.drawable.sampel_event);
        Glide.with(holder.gmbrEvent.getContext())
                .load("https://admin.rangkanada.com/storage/" + event.getImage()) // Ganti dengan method untuk mendapatkan URL gambar dari objek EventModel
                .placeholder(R.drawable.sampel_event) // Placeholder saat gambar sedang dimuat
                .error(R.drawable.sampel1) // Gambar yang akan ditampilkan jika terjadi kesalahan saat memuat gambar
                .into(holder.gmbrEvent);
        // Set TextView lainnya dengan atribut lainnya dari objek EventModel
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Implementasi aksi yang dijalankan saat item diklik
//                // Misalnya, berpindah ke halaman detail event
//                Intent intent = new Intent(v.getContext(), DetailEvent.class);
//                intent.putExtra("event_deskripsi", event.getDeskripsi()); // Misalnya, mengirimkan ID event
//                intent.putExtra("event_nama", event.getNama_event()); // Misalnya, mengirimkan nama event
//                intent.putExtra("gambar", event.getImage());
//                intent.putExtra("lokasi", event.getLokasi());
//                intent.putExtra("tanggal", event.getTanggal() );
//                intent.putExtra("coordinate", coordinateString);
//                intent.putExtra("idpake", idpake );
//                // Kirim data event lainnya sesuai kebutuhan
//
//                v.getContext().startActivity(intent); // Mulai aktivitas baru dengan Intent yang telah dibuat
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
