package com.example.ThirdAssignment.ui.addstudents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddstudentsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddstudentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}