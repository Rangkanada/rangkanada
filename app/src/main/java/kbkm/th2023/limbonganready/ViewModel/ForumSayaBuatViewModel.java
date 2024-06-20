package kbkm.th2023.limbonganready.ViewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.ForumSayaBuatModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumSayaBuatViewModel extends AndroidViewModel {
    private MutableLiveData<List<ForumSayaBuatModel>> forumList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;

    public ForumSayaBuatViewModel(Application application) {
        super(application);
        preferenceManager = new PreferenceManager(application);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<ForumSayaBuatModel>> getForums() {
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
        Call<List<ForumSayaBuatModel>> call = apiService.getForumSayaBuat(token, userId);
        call.enqueue(new Callback<List<ForumSayaBuatModel>>() {
            @Override
            public void onResponse(Call<List<ForumSayaBuatModel>> call, Response<List<ForumSayaBuatModel>> response) {
                if (response.isSuccessful()) {
                    forumList.setValue(response.body());
                    Toast.makeText(getApplication(), "Gokil: " + response.message(), Toast.LENGTH_LONG).show();
                } else {
                    // Gunakan Application Context untuk menampilkan Toast
                    Toast.makeText(getApplication(), "Failed to load forums: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ForumSayaBuatModel>> call, Throwable t) {
                // Handle error
            }
        });
    }
}