package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Adapater.FoodAdapater;
import com.example.foodorderingapp.Adapater.RestaurantFoodAdapter;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.R;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    RecyclerView rv_food,recyclerView;

    public static List<Food> foodlist;
    public static  List<Food> lstfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        rv_food = findViewById(R.id.recyclerview_food);




        foodlist =new ArrayList<>();
        foodlist.add(new Food("Burger","Rs,120","ChickenHouse","aAs"));
        foodlist.add(new Food("Burger","Rs,120","ChickenHouse","aUs"));
        foodlist.add(new Food("Burger","Rs,120","ChickenHouse","aJs"));


        FoodAdapater foodAdapater = new FoodAdapater(this,foodlist);
        rv_food.setAdapter(foodAdapater);
        rv_food.setLayoutManager(new LinearLayoutManager(this));




    }
}
