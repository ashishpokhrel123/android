package com.example.foodordering_wear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashbaordActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ImageView img;

    public static  List<Food> lstfoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        recyclerView = findViewById(R.id.recyclerwatch);

        FoodApi foodApi = Url.getInstance().create(FoodApi.class);
        Call<List<Food>> foodCall = foodApi.getcategory(Url.token);

        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(DashbaordActivity.this,"Error"+response.code(),Toast.LENGTH_SHORT).show();
                }
                lstfoods = response.body();


                WatchAdapter watchAdapter = new WatchAdapter(DashbaordActivity.this,lstfoods);
                recyclerView.setAdapter(watchAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(DashbaordActivity.this,RecyclerView.HORIZONTAL,false));

            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

                Toast.makeText(DashbaordActivity.this,"Error",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
