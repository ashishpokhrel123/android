package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.R;

import java.util.ArrayList;
import java.util.List;

public class FooddetailsActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    public static List<Food> lstfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetails);

        recyclerView = findViewById(R.id.recyclerview_food);

        lstfood = new ArrayList<>();




    }
}
