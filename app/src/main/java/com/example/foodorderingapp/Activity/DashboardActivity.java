package com.example.foodorderingapp.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.foodorderingapp.Fragment.HomeFragment;
import com.example.foodorderingapp.Interface.UserApi;
import com.example.foodorderingapp.Model.ExploreFood;
import com.example.foodorderingapp.Model.HotDeals;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.URL.Url.token;
import static java.security.AccessController.getContext;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbar;
    ActionBarDrawerToggle dt;

    ImageView cartimg;

    Button btnviewfood;

    //TextView logout;

   // CircleImageView userprofile;

    Fragment selectedFragment = null;
    public static List<ExploreFood> lstexfood = new ArrayList<>();
    public static List<HotDeals> lstdeals = new ArrayList<>();
    public static  List<Restuarant> lstres = new ArrayList<>();
    public static  List<ExploreFood> lstpop = new ArrayList<>();
    SharedPreferences sharedPreferences;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       // nv = findViewById(R.id.bottom_navigation);
         Toolbar toolbar = findViewById(R.id.app_bar);
         //userprofile = findViewById(R.id.userprofile);

      getSupportActionBar().hide();
        drawer = findViewById(R.id.drawer);
        NavigationView nv = findViewById(R.id.bottom_navigation);
        nv.setNavigationItemSelectedListener(this);
        cartimg = findViewById(R.id.cartlist);

        dt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //updateNavigationviewHeader();
                loaduser();
                logout();

            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }


        };
        drawer.addDrawerListener(dt);

        dt.syncState();
        lstexfood = new ArrayList<>();
        lstexfood.add(new ExploreFood(R.drawable.foodupd,"Food"));
        lstexfood.add(new ExploreFood(R.drawable.bervage,"Berveage"));
        lstexfood.add(new ExploreFood(R.drawable.dessert,"Dessert"));
        lstexfood.add(new ExploreFood(R.drawable.ffries,"Drink and Snacks"));


        lstdeals = new ArrayList<>();
        lstdeals.add(new HotDeals(R.drawable.burger1));
        lstdeals.add(new HotDeals(R.drawable.chickenfried));
        lstdeals.add(new HotDeals(R.drawable.pizza));

        lstres = new ArrayList<>();
        lstres.add(new Restuarant("KFC",R.drawable.fries));
        lstres.add(new Restuarant("Burger House",R.drawable.burger));
        lstres.add(new Restuarant("Hotel Annapurna",R.drawable.pasta));

        lstpop = new ArrayList<>();
        lstpop.add(new ExploreFood(R.drawable.momo,"Momo"));
        lstpop.add(new ExploreFood(R.drawable.noodles,"Noodles"));
        lstpop.add(new ExploreFood(R.drawable.cofee,"Cofee"));


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    new HomeFragment()).commit();
            nv.setCheckedItem(R.id.home);
        }

      cartimg.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i  = new Intent(DashboardActivity.this,CartActivity.class);
              startActivity(i);
          }
      });
    }

    private void logout() {

        if(token !="Bearer "){
            token = "Bearer ";
        }


    }
    private void loaduser() {
        final UserApi userApi = Url.getInstance().create(UserApi.class);
        Call<User>  usercall  = userApi.getuserdetails(token);

        usercall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String imgPath = Url.imagePath +  response.body().getProfileimage();
                String username =  response.body().getName();
                Toast.makeText(DashboardActivity.this,"image:"+imgPath,Toast.LENGTH_SHORT).show();
                Toast.makeText(DashboardActivity.this,"name:"+username,Toast.LENGTH_SHORT).show();TextView navigationtxtuser = (TextView)drawer.findViewById(R.id.txtuser);
                ImageView profile = (ImageView)drawer.findViewById(R.id.userprofile);
                navigationtxtuser.setText(username);
                try{

                    Picasso.get().load(imgPath).into(profile);

                 }catch (Exception e){
                    Picasso.get().load(R.drawable.burger).into(profile);

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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
            case R.id.account:
                logout();
                Intent i = new Intent(DashboardActivity.this,LoginActivity.class);
                startActivity(i);

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}


