package com.example.foodordering_wear;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    private EditText ed1,ed2;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed1 = findViewById(R.id.etusername);
        ed2 = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });



        // Enables Always-on

    }

    private void login() {
        String uname = ed1.getText().toString();
        String pwd = ed2.getText().toString();



        User user = new User(uname,pwd);

        UserApi  userApi = Url.getInstance().create(UserApi.class);
        Call<UserResponse> userloginresponse = userApi.login(user);

        userloginresponse.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Username or password not match",Toast.LENGTH_SHORT).show();

                }else{


                    Url.token += response.body().getToken();


                   Toast.makeText(MainActivity.this,"token:"+Url.token,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,DashbaordActivity.class);
                    i.putExtra("token",response.body().getToken());
                    startActivity(i);






                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void openDashBoard(){

    }


}

