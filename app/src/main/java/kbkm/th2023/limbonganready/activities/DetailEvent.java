package kbkm.th2023.limbonganready.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kbkm.th2023.limbonganready.R;

public class DetailEvent extends AppCompatActivity {
    TextView judulEvent;
    TextView deskripsiEvent;

    TextView tanggalEvent;

    TextView lokasiEvent;

    ImageView imageEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        Intent intent = getIntent();
        if (intent != null) {
            String eventDeskripisi = intent.getStringExtra("event_deskripsi");
            String eventNama = intent.getStringExtra("event_nama");
            String eventTanggal = intent.getStringExtra("tanggal");
            String lokasi = intent.getStringExtra("lokasi");
            String gambar = intent.getStringExtra("gambar");

            judulEvent = findViewById(R.id.eventTitle);
            deskripsiEvent = findViewById(R.id.eventDescription);
            lokasiEvent = findViewById(R.id.eventLocation);
            tanggalEvent = findViewById(R.id.eventTime);
            imageEvent = findViewById(R.id.eventImage);

            judulEvent.setText(eventNama);
            deskripsiEvent.setText(eventDeskripisi);
            lokasiEvent.setText(lokasi);


            String dateString = eventTanggal;
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

            try {
                Date date = inputFormat.parse(dateString);
                String formattedDate = outputFormat.format(date);
                tanggalEvent.setText(formattedDate);


            } catch (ParseException e) {
                e.printStackTrace();
            }
            Glide.with(this)
                    .load("http://192.168.40.244/rangkanada/public/storage/" + gambar) // Ganti dengan method untuk mendapatkan URL gambar dari objek EventModel
                    .placeholder(R.drawable.sampel_event) // Placeholder saat gambar sedang dimuat
                    .error(R.drawable.sampel1) // Gambar yang akan ditampilkan jika terjadi kesalahan saat memuat gambar
                    .into(imageEvent);


            // Terima data event lainnya sesuai kebutuhan
        }
    }
}