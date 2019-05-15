package com.example.umangburman.databindingwithlivedata.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.umangburman.databindingwithlivedata.Model.LoginUser;
import com.example.umangburman.databindingwithlivedata.R;
import com.example.umangburman.databindingwithlivedata.ViewModel.LoginViewModel;
import com.example.umangburman.databindingwithlivedata.databinding.ActivityMainBinding;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    private ActivityMainBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.setLifecycleOwner(this);

        binding.setLoginViewModel(loginViewModel);

        context = this;

        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable LoginUser loginUser) {

                if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())){
                    Toasty.success(context,"Enter an E-Mail Address", Toast.LENGTH_SHORT).show();
                    binding.txtEmailAddress.setError("Enter an E-Mail Address");
                    binding.txtEmailAddress.requestFocus();
                }else if(!loginUser.isEmailValid()){
                    Toasty.success(context,"Enter an Valid E-mail Address", Toast.LENGTH_SHORT).show();
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                }else if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())){
                    Toasty.success(context,"Enter a Password", Toast.LENGTH_SHORT).show();
                    binding.txtPassword.setError("Enter a Password");
                    binding.txtPassword.requestFocus();
                }else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    Toasty.success(context,"Enter at least 6 Digit password", Toast.LENGTH_SHORT).show();
                    binding.txtPassword.setError("Enter at least 6 Digit password");
                    binding.txtPassword.requestFocus();
                }
                else {
                    Toasty.success(context,"Login Success", Toast.LENGTH_SHORT).show();
                    binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress());
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                }

            }
        });

    }
}
