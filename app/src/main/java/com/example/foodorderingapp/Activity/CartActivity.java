package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodorderingapp.R;

public class CartActivity extends AppCompatActivity {

           Toolbar toolbar;
           RecyclerView recyclerView;
           TextView txtprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = findViewById(R.id.cart_toolbar);
        recyclerView = findViewById(R.id.recycler_cart);
        txtprice = findViewById(R.id.final_price);
    }
}
