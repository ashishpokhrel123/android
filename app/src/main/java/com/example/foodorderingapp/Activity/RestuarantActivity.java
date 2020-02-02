package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodorderingapp.R;

public class RestuarantActivity extends AppCompatActivity {

    TextView txtname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant);

        getSupportActionBar().hide();

        String name = getIntent().getStringExtra("name");

        //txtname = findViewById(R.id.txtname);
        //txtname.setText(name);
    }
}
