package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodorderingapp.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtnext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

       txtnext = findViewById(R.id.txtnext1);

       txtnext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(i);
           }
       });

   ;



    }

}
