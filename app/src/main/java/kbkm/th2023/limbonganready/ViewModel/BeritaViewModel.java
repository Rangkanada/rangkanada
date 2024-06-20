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
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeritaViewModel extends ViewModel {
    private MutableLiveData<List<Berita>> beritaList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private static final String TAG = "Berita";
    public BeritaViewModel(Context context) {
        preferenceManager = new PreferenceManager(context);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<Berita>> getBerita() {
        if (beritaList == null) {
            beritaList = new MutableLiveData<>();
            loadForums();
        }else{
            beritaList = new MutableLiveData<>();
            loadForums();
        }
        return beritaList;
    }
    public void loadForums() {

        String userToken = preferenceManager.getUserToken();
        int iduser = preferenceManager.getUserId();
        String token = "Bearer " + userToken;
        Call<List<Berita>> call = apiService.getBerita(token);
        call.enqueue(new Callback<List<Berita>>()   {
            @Override
            public void onResponse(Call<List<Berita>> call, Response<List<Berita>> response) {
                if (response.isSuccessful()) {
                    beritaList.setValue(response.body());
                    Log.d(TAG, "ondol");
                }else{
                    Log.d(TAG, "goks");
                }
            }

            @Override
            public void onFailure(Call<List<Berita>> call, Throwable t) {
                // Handle error
                Log.d(TAG, "kocak");
            }
        });
    }
}
