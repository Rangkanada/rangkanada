package kbkm.th2023.limbonganready.ViewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.ForumSayaModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumSayaViewModel extends AndroidViewModel {
    private MutableLiveData<List<ForumSayaModel>> forumList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;

    public ForumSayaViewModel(@NonNull Application application) {
        super(application);
        preferenceManager = new PreferenceManager(application);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<ForumSayaModel>> getForums() {
        if (forumList == null) {
            forumList = new MutableLiveData<>();
            loadForums();
        }
        return forumList;
    }

    private void loadForums() {
        String userToken = preferenceManager.getUserToken();
        int userId = preferenceManager.getUserId();
        String token = "Bearer " + userToken;
        Call<List<ForumSayaModel>> call = apiService.getForumSaya(token, userId);
        call.enqueue(new Callback<List<ForumSayaModel>>() {
            @Override
            public void onResponse(Call<List<ForumSayaModel>> call, Response<List<ForumSayaModel>> response) {
                if (response.isSuccessful()) {
                    forumList.setValue(response.body());
                } else {
                    Toast.makeText(getApplication(), "Failed to load forums: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ForumSayaModel>> call, Throwable t) {
                Toast.makeText(getApplication(), "Failed to load forums: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}