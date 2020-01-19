package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderingapp.Adapater.PopularCategory;
import com.example.foodorderingapp.Model.PopCategory;
import com.example.foodorderingapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<PopCategory> lstcat;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        rv = findViewById(R.id.recyclerview);

        lstcat = new ArrayList<>();

        lstcat.add(new PopCategory(R.drawable.burger,"Burger"));
        lstcat.add(new PopCategory(R.drawable.sandwiche,"Sandwiche"));
        lstcat.add(new PopCategory(R.drawable.burger,"Burger"));
        lstcat.add(new PopCategory(R.drawable.sandwiche,"Sandwiche"));
        lstcat.add(new PopCategory(R.drawable.burger,"Burger"));
        lstcat.add(new PopCategory(R.drawable.sandwiche,"Sandwiche"));

        PopularCategory pca = new PopularCategory(this,lstcat);
        rv.setAdapter(pca);
        rv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));




    }

}
