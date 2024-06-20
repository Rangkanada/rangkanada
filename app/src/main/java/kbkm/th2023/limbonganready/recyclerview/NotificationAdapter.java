package kbkm.th2023.limbonganready.recyclerview;

import android.app.Notification;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.model.Chat;
import kbkm.th2023.limbonganready.model.Notifikasi;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ChatViewHolder> {

    private List<Notifikasi> notificationList;

    PreferenceManager preferenceManager;

    private Set<Integer> notifikasiIdSet = new HashSet<>();

    public NotificationAdapter(List<Notifikasi> notificationList, PreferenceManager preferenceManager) { // Modifikasi konstruktor
        this.notificationList = notificationList;
        this.preferenceManager = preferenceManager; // Inisialisasi PreferenceManager
        notifikasiIdSet = new HashSet<>();
        // Perulangan untuk menambahkan userId dari setiap Chat ke dalam userIdSet
        for (Notifikasi notifikasi : notificationList) {
            notifikasiIdSet.add(notifikasi.getId());
        }
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ChatViewHolder(view, new PreferenceManager(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Notifikasi notifikasi = notificationList.get(position);
        holder.bind(notifikasi, notifikasiIdSet);
    }

    @Override
    public int getItemCount() {
        return notificationList != null ? notificationList.size() : 0;
    }

    public void setNotificationList(List<Notifikasi> notificationList) {
        this.notificationList = notificationList;
        notifyDataSetChanged();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView notif;

        private PreferenceManager preferenceManager; // Tambahkan PreferenceManager


        public ChatViewHolder(@NonNull View itemView, PreferenceManager preferenceManager) {
            super(itemView);
            notif = itemView.findViewById(R.id.teksNotif);
            this.preferenceManager = preferenceManager;


        }

        public void bind(Notifikasi notifikasi, Set<Integer> userIdSet) {


            notif.setText(notifikasi.getMessage());

            int userId = preferenceManager.getUserId();
            Log.d("Notifikasi", "User Id: " + userId); // Tampilkan userId ke Log


        }
    }
}
