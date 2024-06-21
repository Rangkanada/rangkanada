package kbkm.th2023.limbonganready.ViewModel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class EventBaruViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public EventBaruViewModelFactory(Context context) {
        this.context = context.getApplicationContext(); // Use application context to avoid memory leaks
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(EventBaruViewModel.class)) {
            return (T) new EventBaruViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
