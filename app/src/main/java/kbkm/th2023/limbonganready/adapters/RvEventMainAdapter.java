package kbkm.th2023.limbonganready.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.activities.DetailEvent;
import kbkm.th2023.limbonganready.objects.Events;

public class RvEventMainAdapter extends RecyclerView.Adapter<RvEventMainAdapter.ViewHolder> {
    private ArrayList<Events> eventsArrayList;
    private Context mContext;
    private String param;

    public RvEventMainAdapter(ArrayList<Events> eventsArrayList, Context mContext, String param) {
        this.eventsArrayList = eventsArrayList;
        this.mContext = mContext;
        this.param = param;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (param.equals("fragment_home")) {
            return new ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_event_main, parent, false)
            );
        } else {
            return new ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_event_detail, parent, false)
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Events events = eventsArrayList.get(position);

        holder.eventImage.setImageResource(events.getGambar());
        holder.judulEvent.setText(events.getJudul());
        holder.tanggalEvent.setText(events.getTanggal());//mengambil data dari objek event

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle klik item di sini

                // Memulai aktivitas baru atau berpindah ke layout baru
                Intent intent = new Intent(view.getContext(), DetailEvent.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView eventImage;
        public TextView judulEvent;
        public TextView tanggalEvent;
        public ViewHolder(View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.musik);
            judulEvent = itemView.findViewById(R.id.textMusik);
            tanggalEvent = itemView.findViewById(R.id.txtdetailMusik);
        }
    }
}
