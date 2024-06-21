package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.Berita;
import kbkm.th2023.limbonganready.model.EventModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventBaruViewModel extends ViewModel {
    private MutableLiveData<List<EventModel>> eventList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private static final String TAG = "Berita";
    public EventBaruViewModel(Context context) {
        preferenceManager = new PreferenceManager(context);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<EventModel>> getEvent() {
        if (eventList == null) {
            eventList = new MutableLiveData<>();
            loadForums();
        }else{
            eventList = new MutableLiveData<>();
            loadForums();
        }
        return eventList;
    }
    public void loadForums() {

        String userToken = preferenceManager.getUserToken();
        int iduser = preferenceManager.getUserId();
        String token = "Bearer " + userToken;
        Call<List<EventModel>> call = apiService.getEventBaru(token);
        call.enqueue(new Callback<List<EventModel>>()   {
            @Override
            public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                if (response.isSuccessful()) {
                    eventList.setValue(response.body());
                    Log.d(TAG, "ondol");
                }else{
                    Log.d(TAG, "goks");
                }
            }

            @Override
            public void onFailure(Call<List<EventModel>> call, Throwable t) {

            }


        });
    }
}
