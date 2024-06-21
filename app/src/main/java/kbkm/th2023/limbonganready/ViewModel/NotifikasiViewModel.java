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
import kbkm.th2023.limbonganready.model.Notifikasi;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotifikasiViewModel extends ViewModel {

    private MutableLiveData<List<Notifikasi>> notifications;
    private ApiService apiService;
    private PreferenceManager preferenceManager;
    private Handler handler;
    private Runnable runnable;
    private static final long POLLING_INTERVAL = 5000; // 5 detik

    private Set<Integer> userNotifikasi = new HashSet<>();

    public NotifikasiViewModel() {
        notifications = new MutableLiveData<>();
        apiService = RetrofitClient.getClient().create(ApiService.class);
        handler = new Handler(Looper.getMainLooper());
    }

    public void init(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public LiveData<List<Notifikasi>> getNotifikasi(PreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
        startPolling();
        return notifications;
    }

    private void startPolling() {
        runnable = new Runnable() {
            @Override
            public void run() {
                fetchNotification();
                handler.postDelayed(this, POLLING_INTERVAL);
            }
        };
        handler.post(runnable);
    }

    private void fetchNotification() {
        String token = "Bearer " + preferenceManager.getUserToken();
        Call<List<Notifikasi>> call = apiService.getNotifikasi(token);
        call.enqueue(new Callback<List<Notifikasi>>() {
            @Override
            public void onResponse(Call<List<Notifikasi>> call, Response<List<Notifikasi>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    notifications.setValue(response.body());

                    Log.d("Notifikasi", "Data notifikasi berhasil dimuat");
                } else {
                    Log.d("Notifikasi", "Gagal memuat data chats: " + response.message());

                }
            }

            @Override
            public void onFailure(Call<List<Notifikasi>> call, Throwable t) {
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
