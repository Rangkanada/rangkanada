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
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KoleksiEventViewModel extends ViewModel {
    private MutableLiveData<List<EventDetail>> koleksiEvent;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private static final String TAG = "Koleksi Forum";

    public KoleksiEventViewModel(Context context) {
        preferenceManager = new PreferenceManager(context);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<EventDetail>> getKoleksiEvent() {
        if (koleksiEvent == null) {
            koleksiEvent = new MutableLiveData<>();
            loadKoleksiEvent();
        }else{
            koleksiEvent = new MutableLiveData<>();
            loadKoleksiEvent();
        }
        return koleksiEvent;
    }

    public void loadKoleksiEvent() {
        String userToken = preferenceManager.getUserToken();
        int userId = preferenceManager.getUserId();
        String token = "Bearer " + userToken;
        Call<List<EventDetail>> call = apiService.getKoleksiEvent(token, userId);
        call.enqueue(new Callback<List<EventDetail>>() {
            @Override
            public void onResponse(Call<List<EventDetail>> call, Response<List<EventDetail>> response) {
                if (response.isSuccessful()) {
                    koleksiEvent.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<EventDetail>> call, Throwable t) {
                // Handle error
                Log.d(TAG, "KOKBISa");
            }
        });
    }
}