package kbkm.th2023.limbonganready.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.objects.Events;

public class RvEventAdapter extends RecyclerView.Adapter<RvEventAdapter.ViewHolder> {
    private ArrayList<Events> eventsArrayList;
    private Context mContext;

    public RvEventAdapter(ArrayList<Events> eventsArrayList, Context mContext) {
        this.eventsArrayList = eventsArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_event, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Events events = eventsArrayList.get(position);

        holder.eventImage.setImageResource(events.getGambar());
        holder.judulEvent.setText(events.getJudul()); //mengambil data dari objek event
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView eventImage;
        public TextView judulEvent;
        public ViewHolder(View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.musik);
            judulEvent = itemView.findViewById(R.id.JudulEvent);
        }
    }
}
