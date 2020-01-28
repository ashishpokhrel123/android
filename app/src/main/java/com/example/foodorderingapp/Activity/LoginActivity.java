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

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private EditText etusername,etpassword;
    private Button btnlogin;
    private TextView txtreg;
    private CheckBox chk;

    SharedPreferences sharedPreferences;



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
        if(chk.isChecked()) {
            User usr = new User(etusername.getText().toString(), etpassword.getText().toString());

            UserApi userApi = Url.getInstance().create(UserApi.class);
            Call<UserResponse> userResponse = userApi.login(usr);

            try {

                Response<UserResponse> userlogin = userResponse.execute();
                if (userlogin.isSuccessful() &&
                        userlogin.body().getStatus().equals("Login success!"))


                    sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                Url.token += userlogin.body().getToken();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            sharedPreferences=getSharedPreferences("User",0);
            sharedPreferences.edit().clear().commit();

            Toast.makeText(LoginActivity.this,"Please check box",Toast.LENGTH_SHORT).show();
        }




    }
  public void openDashBoard(){
        Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
        startActivity(i);
  }




}
