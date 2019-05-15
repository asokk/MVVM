package com.example.edmtdevmvvm;



//This class is used to handle ViewModel

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallbacks mLoginResultCallbacks;

    public LoginViewModelFactory(LoginResultCallbacks mLoginResultCallbacks) {
        this.mLoginResultCallbacks = mLoginResultCallbacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(mLoginResultCallbacks);
    }
}
