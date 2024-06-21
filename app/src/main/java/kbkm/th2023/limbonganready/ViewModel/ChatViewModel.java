package kbkm.th2023.limbonganready.ViewModel;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.Chat;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatViewModel extends ViewModel {

    private MutableLiveData<List<Chat>> chats;
    private ApiService apiService;
    private PreferenceManager preferenceManager;
    private Handler handler;
    private Runnable runnable;
    private static final long POLLING_INTERVAL = 5000; // 5 detik

    private Set<Integer> userChat = new HashSet<>();

    public ChatViewModel() {
        chats = new MutableLiveData<>();
        apiService = RetrofitClient.getClient().create(ApiService.class);
        handler = new Handler(Looper.getMainLooper());
    }

    public void init(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public LiveData<List<Chat>> getChat(int forumId, PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
        startPolling(forumId);
        return chats;
    }

    private void startPolling(int forumId) {
        runnable = new Runnable() {
            @Override
            public void run() {
                fetchChats(forumId);
                handler.postDelayed(this, POLLING_INTERVAL);
            }
        };
        handler.post(runnable);
    }

    private void fetchChats(int forumId) {
        String token = "Bearer " + preferenceManager.getUserToken();
        Call<List<Chat>> call = apiService.getChats(token, forumId);
        call.enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    chats.setValue(response.body());


                    Log.d("ChatViewModel", "Data chats berhasil dimuat");
                } else {
                    try {
                        Log.d("ChatViewModel", "Gagal memuat data chats: " + response.message());
                        Log.d("ChatViewModel", "Response code: " + response.code());
                        Log.d("ChatViewModel", "Response error body: " + response.errorBody().string());
                        Log.d("ChatViewModel", "Response headers: " + response.headers().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {
                Log.d("ChatViewModel", "Gagal memuat data chats: " + t.getMessage());
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        handler.removeCallbacks(runnable);
    }
}
