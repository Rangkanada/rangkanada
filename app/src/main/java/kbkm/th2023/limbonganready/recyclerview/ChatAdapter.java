package kbkm.th2023.limbonganready.recyclerview;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import kbkm.th2023.limbonganready.preferences.PreferenceManager;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chat> chatList;
    private static final SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

    private Set<Integer> userIdSet = new HashSet<>();

    public ChatAdapter(List<Chat> chatList, PreferenceManager preferenceManager) { // Modifikasi konstruktor
        this.chatList = chatList;
//        this.preferenceManager = preferenceManager; // Inisialisasi PreferenceManager
        userIdSet = new HashSet<>();
        // Perulangan untuk menambahkan userId dari setiap Chat ke dalam userIdSet
        for (Chat chat : chatList) {
            userIdSet.add(chat.getUserId());
        }
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskusi, parent, false);
        return new ChatViewHolder(view, new PreferenceManager(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.bind(chat, userIdSet);
    }

    @Override
    public int getItemCount() {
        return chatList != null ? chatList.size() : 0;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
        notifyDataSetChanged();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView message;
        private TextView sentAt;
        private PreferenceManager preferenceManager; // Tambahkan PreferenceManager

        private LinearLayout chatCard;
        private  CardView cardIni;





        public ChatViewHolder(@NonNull View itemView, PreferenceManager preferenceManager) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            message = itemView.findViewById(R.id.postContent);
            sentAt = itemView.findViewById(R.id.postingTime);
            chatCard = itemView.findViewById(R.id.chatCard);
            cardIni = itemView.findViewById(R.id.cardIni);
            this.preferenceManager = preferenceManager;



        }

        public void bind(Chat chat,  Set<Integer> userIdSet) {


            message.setText(chat.getMessage());

            int userId = preferenceManager.getUserId();
            Log.d("ChatAdapter", "UserId: " + userId); // Tampilkan userId ke Log

            Log.d("ChatUser", "UserId: " + chat.getUserId()); // Tampilkan userId ke Log


            userName.setText(chat.getUserName());

            String formattedDate = formatDate(chat.getSentAt().toString());

            sentAt.setText(formattedDate != null ? formattedDate : "Unknown");
            if (chat.getUserId() == userId) {
                // Jika pengguna saat ini adalah pengirim pesan
                cardIni.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD0D0"))); // Warna kuning
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.gravity = Gravity.END;
                cardIni.setLayoutParams(layoutParams);
                userName.setText(chat.getUserName() + " (SAYA) ");
            } else {
                // Jika pengguna saat ini bukan pengirim pesan
                cardIni.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C1DDD2"))); // Warna kuning
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.gravity = Gravity.START;
                cardIni.setLayoutParams(layoutParams);
            }
        }
        private String formatDate(String dateString) {
            try {
                Date date = inputFormat.parse(dateString);
                return outputFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
                return dateString; // return original string if parsing fails
            }
        }

    }
}
