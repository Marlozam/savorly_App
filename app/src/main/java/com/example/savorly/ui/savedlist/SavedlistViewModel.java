package com.example.savorly.ui.savedlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SavedlistViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SavedlistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is saved list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
