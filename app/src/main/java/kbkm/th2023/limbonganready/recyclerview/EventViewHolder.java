package kbkm.th2023.limbonganready.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import kbkm.th2023.limbonganready.R;

public class EventViewHolder extends RecyclerView.ViewHolder {
    TextView textNamaEvent;
    TextView textViewDate;
    TextView textViewLokasi;
    ImageView gambar;
    public EventViewHolder(View itemView) {
        super(itemView);
        textNamaEvent = itemView.findViewById(R.id.JudulEvent);
        textViewDate = itemView.findViewById(R.id.textViewDate);
        textViewLokasi = itemView.findViewById(R.id.textViewTempat);
        gambar = itemView.findViewById(R.id.ImageEvent);

        // Inisialisasi elemen lainnya jika ada
    }
}