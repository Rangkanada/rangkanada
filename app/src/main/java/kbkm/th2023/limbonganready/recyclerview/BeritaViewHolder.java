package kbkm.th2023.limbonganready.recyclerview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import kbkm.th2023.limbonganready.R;

public class BeritaViewHolder extends RecyclerView.ViewHolder {
    TextView judulBerita;
    TextView sumberBerita;
    TextView linkBerita;
    Button selengkapnya;
    ImageView gambarBerita;
    public BeritaViewHolder(View itemView) {
        super(itemView);
       judulBerita = itemView.findViewById(R.id.judulBerita);
       sumberBerita = itemView.findViewById(R.id.sumberBerita);
       gambarBerita = itemView.findViewById(R.id.gambarBerita);
       selengkapnya = itemView.findViewById(R.id.tombolSelengkapnya);


        // Inisialisasi elemen lainnya jika ada
    }
}