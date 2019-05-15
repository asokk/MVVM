package com.example.edmtdevmvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;


public class User extends BaseObservable {
    String email;
    String password;


    public User(){

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }





    public int isValidData() {
      /*  return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length()>6;
    */
      if(TextUtils.isEmpty(getEmail()) ){
          return 0;
      }else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
          return 1;
      } else if(TextUtils.isEmpty(getPassword())){
          return 2;
      }else if(getPassword().length()<6){
          return 3;
      }else
          return -1;
    }
}
