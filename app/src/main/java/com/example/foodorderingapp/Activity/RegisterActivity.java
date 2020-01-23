package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText etname,etemail,etphone,etusername,etpassword;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Registration");

        etname = findViewById(R.id.name);
        etemail = findViewById(R.id.email);
        etphone = findViewById(R.id.phone);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnsignup = findViewById(R.id.signup);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    public void signup(){
        User usr = new User(etname.getText().toString(), etemail.getText().toString(),
                etphone.getText().toString(),etusername.getText().toString(),etpassword.getText().toString());

        UserApi userApi = Url.getInstance().create(UserApi.class);
        Call<Void>   registercall = userApi.signup(usr);

        registercall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Code: " +response.body(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent signUpComplete = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(signUpComplete);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }













}
