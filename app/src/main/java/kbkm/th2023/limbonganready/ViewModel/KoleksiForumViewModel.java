package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.EventDetail;
import kbkm.th2023.limbonganready.model.ForumResponse;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KoleksiForumViewModel extends ViewModel {
    private MutableLiveData<List<ForumResponse>> koleksiForum;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private static final String TAG = "Koleksi Forum";

    public KoleksiForumViewModel(Context context) {
        preferenceManager = new PreferenceManager(context);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<ForumResponse>> getKoleksiForum() {
        if (koleksiForum == null) {
            koleksiForum = new MutableLiveData<>();
            loadKoleksiEvent();
        }else{
            koleksiForum = new MutableLiveData<>();
            loadKoleksiEvent();
        }
        return koleksiForum;
    }

    public void loadKoleksiEvent() {
        String userToken = preferenceManager.getUserToken();
        int userId = preferenceManager.getUserId();
        Log.d(TAG, "onItemDeleted Goks");
        String token = "Bearer " + userToken;
        Call<List<ForumResponse>> call = apiService.getKoleksiForum(token, userId);
        call.enqueue(new Callback<List<ForumResponse>>() {
            @Override
            public void onResponse(Call<List<ForumResponse>> call, Response<List<ForumResponse>> response) {
                if (response.isSuccessful()) {
                    koleksiForum.setValue(response.body());
                    Log.d(TAG, "onItemDeleted Goks");
                }else{
                    Log.d(TAG, "onItemDeleted Gagal");
                }
            }

            @Override
            public void onFailure(Call<List<ForumResponse>> call, Throwable t) {
                // Handle error
                Log.d(TAG, "onItemDeleted Goks");

            }
        });
    }
}