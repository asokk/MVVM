package com.example.edmtdevmvvm;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;


public class LoginViewModel extends ViewModel {

    private User mUser;
    private LoginResultCallbacks mLoginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.mLoginResultCallbacks = loginResultCallbacks;
        this.mUser = new User();
    }

    //Write method to get Email from Edittext and set to User
    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setEmail(s.toString());
            }
        };
    }

    //Write method to get Password from Edittext and set to User
    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setPassword(s.toString());
            }
        };
    }

    //Write Method to process Login

    public void onLoginClicked(View view){
        int errorCode = mUser.isValidData();
         if(errorCode == 0){
             mLoginResultCallbacks.onError("YOu must enter email address");
         }else if(errorCode ==1){
             mLoginResultCallbacks.onError("Your EMail is inValid");
         }else if(errorCode ==2){
             mLoginResultCallbacks.onError("You must enter password");
         }else if(errorCode ==3){
             mLoginResultCallbacks.onError("Password length must be greater than 6");
         }else
             mLoginResultCallbacks.onSuccess("Login Success");
    }
}
