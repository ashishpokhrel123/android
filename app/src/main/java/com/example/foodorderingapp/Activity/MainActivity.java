package com.example.foodorderingapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.foodorderingapp.Adapater.PopularCategory;
import com.example.foodorderingapp.Model.PopCategory;
import com.example.foodorderingapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle dt;

    ImageView iv;
    private
    List<PopCategory> lstcat;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();

        dl = (DrawerLayout) findViewById(R.id.rel1);
        dt =  new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);

        dl.addDrawerListener(dt);
        dt.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().back






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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(dt.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
