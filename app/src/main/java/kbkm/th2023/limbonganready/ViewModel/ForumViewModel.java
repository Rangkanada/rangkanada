package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kbkm.th2023.limbonganready.apiService.ApiService;
import kbkm.th2023.limbonganready.apiService.RetrofitClient;
import kbkm.th2023.limbonganready.model.ForumModel;
import kbkm.th2023.limbonganready.preferences.PreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumViewModel extends ViewModel {
    private MutableLiveData<List<ForumModel>> forumList;
    private PreferenceManager preferenceManager;
    private ApiService apiService;
    private static final String TAG = "Forum";
    public ForumViewModel(Context context) {
        preferenceManager = new PreferenceManager(context);
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public LiveData<List<ForumModel>> getForums() {
        if (forumList == null) {
            forumList = new MutableLiveData<>();
            loadForums();
        }else{
            forumList = new MutableLiveData<>();
            loadForums();
        }
        return forumList;
    }
    public void loadForums() {

        String userToken = preferenceManager.getUserToken();
        int iduser = preferenceManager.getUserId();
        String token = "Bearer " + userToken;
        Call<List<ForumModel>> call = apiService.getForum(token, iduser);
        call.enqueue(new Callback<List<ForumModel>>()   {
            @Override
            public void onResponse(Call<List<ForumModel>> call, Response<List<ForumModel>> response) {
                if (response.isSuccessful()) {
                    forumList.setValue(response.body());
                    Log.d(TAG, "ondol");
                }
            }

            @Override
            public void onFailure(Call<List<ForumModel>> call, Throwable t) {
                // Handle error
                Log.d(TAG, "kocak");
            }
        });
    }
}
