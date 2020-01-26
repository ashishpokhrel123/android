package com.example.foodorderingapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.example.foodorderingapp.Fragment.HomeFragment;
import com.example.foodorderingapp.Model.ExploreFood;
import com.example.foodorderingapp.Model.HotDeals;
import com.example.foodorderingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbar;
    Fragment selectedFragment = null;
    public static List<ExploreFood> lstexfood = new ArrayList<>();
    public static List<HotDeals> lstdeals = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       // nv = findViewById(R.id.bottom_navigation);
         Toolbar toolbar = findViewById(R.id.app_bar);
        //getActionBar().hide();
        drawer = findViewById(R.id.drawer);
        NavigationView nv = findViewById(R.id.bottom_navigation);
        nv.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        lstexfood = new ArrayList<>();
        lstexfood.add(new ExploreFood(R.drawable.foodupd,"Food"));
        lstexfood.add(new ExploreFood(R.drawable.bervage,"Berveage"));
        lstexfood.add(new ExploreFood(R.drawable.dessert,"Dessert"));
        lstexfood.add(new ExploreFood(R.drawable.ffries,"Drink and Snacks"));


        lstdeals = new ArrayList<>();
        lstdeals.add(new HotDeals(R.drawable.fries));
        lstdeals.add(new HotDeals(R.drawable.burger));
        lstdeals.add(new HotDeals(R.drawable.sandwiche));

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new HomeFragment()).commit();
            nv.setCheckedItem(R.id.home);
        }


    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new HomeFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}


