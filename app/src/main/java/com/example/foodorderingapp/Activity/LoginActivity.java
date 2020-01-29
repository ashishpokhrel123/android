package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.ServerResponse.UserResponse;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private EditText etusername,etpassword;
    private Button btnlogin;
    private TextView txtreg;
    private CheckBox chk;

    SharedPreferences sharedPreferences,token;

    String name,Username,Password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //getSupportActionBar().hide();

        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.login);
        chk = findViewById(R.id.chkrememberme);

        SharedPreferences savedata =  getSharedPreferences("User", Context.MODE_PRIVATE);
       if(savedata.getString("username","").isEmpty()){
           chk.setChecked(false);
       } else{
           etusername.setText(sharedPreferences.getString("username",""));
           etpassword.setText(sharedPreferences.getString("password",""));
           chk.setChecked(true);
           name = sharedPreferences.getString("name","");
           Username = sharedPreferences.getString("username","");
           openDashBoard();
       }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


       txtreg = findViewById(R.id.tvSignUp);

       txtreg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(i);
           }
       });







    }
    public void login()
    {
        String uname = etusername.getText().toString();
        String pwd = etpassword.getText().toString();


        User user = new User(uname,pwd);

        UserApi  userApi = Url.getInstance().create(UserApi.class);
        Call<UserResponse> userloginresponse = userApi.login(user);

        userloginresponse.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Username or password not match",Toast.LENGTH_SHORT).show();
                }else{
                    if(chk.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",Username);
                        editor.putString("password",Password);
                        editor.putString("name",name);
                        editor.commit();

                    }else{
                        sharedPreferences.edit().commit();
                    }
                    token =  getSharedPreferences("token",MODE_PRIVATE);
                    SharedPreferences.Editor token = sharedPreferences.edit();
                    token.putString("token",response.body().getToken());
                    token.commit();




                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });


    }
  public void openDashBoard(){
        Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(i);
  }




}
