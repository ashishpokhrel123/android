package com.example.foodorderingwearable.Activity.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingwearable.Activity.Activity.API.UserAPI;
import com.example.foodorderingwearable.Activity.Activity.Model.User;
import com.example.foodorderingwearable.Activity.Activity.ServerResponse.UserResponse;
import com.example.foodorderingwearable.Activity.Activity.URL.Url;
import com.example.foodorderingwearable.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etusername,etpassword;

    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername  = findViewById(R.id.edusername);
        etpassword = findViewById(R.id.edpassword);
        btnlogin = findViewById(R.id.btnlogin);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }

    private void login() {
        String uname = etusername.getText().toString();
        String pwd = etpassword.getText().toString();


        User user = new User(uname,pwd);

        UserAPI userApi = Url.getInstance().create(UserAPI.class);
        Call<UserResponse> userloginresponse = userApi.login(user);

        userloginresponse.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Username or password not match",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Token:"+response.body().getToken(),Toast.LENGTH_SHORT).show();


                    Url.token += response.body().getToken();



                    openDashBoard();







                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void openDashBoard(){
        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
    }

}

