package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class KoleksiForumViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public KoleksiForumViewModelFactory(Context context) {
        this.context = context.getApplicationContext(); // Use application context to avoid memory leaks
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(KoleksiForumViewModel.class)) {
            return (T) new KoleksiForumViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
