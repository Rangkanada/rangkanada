package kbkm.th2023.limbonganready.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kbkm.th2023.limbonganready.R;
import kbkm.th2023.limbonganready.ViewModel.ChatViewModel;
import kbkm.th2023.limbonganready.model.Chat;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import kbkm.th2023.limbonganready.recyclerview.ChatAdapter;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forum extends AppCompatActivity {

    private RecyclerView recyclerViewChats;
    private ChatAdapter chatAdapter;
    private ChatViewModel chatViewModel;
    private PreferenceManager preferenceManager;

    private TextView namaforum;

    private ImageView tombolKirim;

    private EditText teksPesan;

    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        tombolKirim = findViewById(R.id.sendButton);
        teksPesan = findViewById(R.id.discussionForm);

        preferenceManager = new PreferenceManager(this);
        apiService = RetrofitClient.getClient().create(ApiService.class);

        namaforum = findViewById(R.id.namaForum);
        chatViewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        chatViewModel.init(preferenceManager);

        recyclerViewChats = findViewById(R.id.recyclerChat);
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(new ArrayList<>(), preferenceManager);  // Pass context to adapter
        recyclerViewChats.setAdapter(chatAdapter);

        int forumId = getIntent().getIntExtra("forum_id", -1);
        String namaForum = getIntent().getStringExtra("nama_forum");

        namaforum.setText(namaForum);
        chatViewModel.getChat(forumId, preferenceManager).observe(this, new Observer<List<Chat>>() {
            @Override
            public void onChanged(List<Chat> chats) {
                chatAdapter.setChatList(chats);
            }
        });

        tombolKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahChat(forumId);
            }
        });
    }

    public void Finish(View view) {
        onBackPressed();
    }

    private void tambahChat(int forumId) {
        String token = "Bearer " + preferenceManager.getUserToken();
        int userId = preferenceManager.getUserId();
        String message = teksPesan.getText().toString().trim();

        if (message.isEmpty()) {
            Toast.makeText(this, "Pesan tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<Void> call = apiService.tambahChat(token, userId, forumId, message);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Forum.this, "Pesan berhasil dikirim", Toast.LENGTH_SHORT).show();
                    teksPesan.setText("");  // Mengosongkan EditText setelah berhasil mengirim pesan

                    // Refresh chat list after sending a message
                    chatViewModel.getChat(forumId, preferenceManager).observe(Forum.this, new Observer<List<Chat>>() {
                        @Override
                        public void onChanged(List<Chat> chats) {
                            chatAdapter.setChatList(chats);
                        }
                    });
                } else {
                    Toast.makeText(Forum.this, "Gagal mengirim pesan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Forum.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
