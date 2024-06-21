package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class BeritaViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public BeritaViewModelFactory(Context context) {
        this.context = context.getApplicationContext(); // Use application context to avoid memory leaks
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BeritaViewModel.class)) {
            return (T) new BeritaViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
