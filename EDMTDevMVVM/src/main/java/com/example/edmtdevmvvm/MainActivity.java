package com.example.edmtdevmvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.edmtdevmvvm.databinding.ActivityMainBinding;


import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setLoginViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this)).get(LoginViewModel.class));
      /*  User user = new User();
        user.setEmail("ashok@gmail.com");
        user.setPassword("12345678");
        activityMainBinding.setViewModel(user);*/
    }

    @Override
    public void onSuccess(String msg) {
//        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        Toasty.success(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
//        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
        Toasty.success(this,msg,Toast.LENGTH_SHORT).show();
    }
}
