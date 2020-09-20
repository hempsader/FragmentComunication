package com.example.fragmentcomunication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> selected = new MutableLiveData<>();

    public void setData(String data)
    {
        selected.setValue(data);
    }

    public LiveData<String> getData()
    {
        return selected;
    }
}
