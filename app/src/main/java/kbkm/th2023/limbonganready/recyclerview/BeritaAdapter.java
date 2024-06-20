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
import kbkm.th2023.limbonganready.activities.DetailBerita;
import kbkm.th2023.limbonganready.activities.DetailEvent;
import kbkm.th2023.limbonganready.model.Berita;
import kbkm.th2023.limbonganready.model.Chat;


public class BeritaAdapter extends RecyclerView.Adapter<BeritaViewHolder> {
    private List<Berita> beritaList;

    public BeritaAdapter(List<Berita> beritaList) {
        this.beritaList = beritaList;
    }
    public void beritaList(List<Berita> beritaList) {
        this.beritaList = beritaList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false);
        return new BeritaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, int position) {
        Berita berita = beritaList.get(position);
      holder.judulBerita.setText(berita.getJudul());
      holder.sumberBerita.setText("Sumber : " + berita.getSumber());


        holder.gambarBerita.setImageResource(R.drawable.sampel_event);
        Glide.with(holder.itemView.getContext())
                .load("http://192.168.193.244/rangkanada/public/storage/" + berita.getGambar()) // Ganti dengan method untuk mendapatkan URL gambar dari objek EventModel
                .placeholder(R.drawable.sampel_event) // Placeholder saat gambar sedang dimuat
                .error(R.drawable.sampel1) // Gambar yang akan ditampilkan jika terjadi kesalahan saat memuat gambar
                .into(holder.gambarBerita);
        // Set TextView lainnya dengan atribut lainnya dari objek EventModel
        holder.selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementasi aksi yang dijalankan saat item diklik
                // Misalnya, berpindah ke halaman detail event
                Intent intent = new Intent(v.getContext(), DetailBerita.class);
                intent.putExtra("judulberita", berita.getJudul()); // Misalnya, mengirimkan ID event
                intent.putExtra("sumberberita", berita.getSumber()); // Misalnya, mengirimkan nama event
                intent.putExtra("gambar", berita.getGambar());
                intent.putExtra("linkberita", berita.getLinkberita());


                v.getContext().startActivity(intent); // Mulai aktivitas baru dengan Intent yang telah dibuat
            }
        });
    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }
}
