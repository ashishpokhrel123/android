package com.example.foodorderingapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView nv;
    private Toolbar toolbar;
    ActionBarDrawerToggle dt;

    private CircleImageView userprofile;
    TextView txt;
    Fragment selectedFragment = null;
    public static List<ExploreFood> lstexfood = new ArrayList<>();
    public static List<HotDeals> lstdeals = new ArrayList<>();
    public static  List<Restuarant> lstres = new ArrayList<>();
    public static  List<ExploreFood> lstpop = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       // nv = findViewById(R.id.bottom_navigation);
         Toolbar toolbar = findViewById(R.id.app_bar);
         userprofile = findViewById(R.id.userprofile);
      getSupportActionBar().hide();
        drawer = findViewById(R.id.drawer);
        NavigationView nv = findViewById(R.id.bottom_navigation);
        nv.setNavigationItemSelectedListener(this);

        dt = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                updateNavigationviewHeader();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }


        };
        drawer.addDrawerListener(dt);

        dt.syncState();




         //txt  = findViewById(R.id.username);



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


    }

    private void updateNavigationviewHeader() {
        nv = (NavigationView) findViewById(R.id.bottom_navigation);
        nv.setNavigationItemSelectedListener(this);
        View  header = nv.getHeaderView(0);


        loaduser();



        SharedPreferences sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
        String user = sharedPreferences.getString("username","");

        TextView username = (TextView) header.findViewById(R.id.txtuser);
        username.setText(user);
    }

    private void loaduser() {
        UserApi userApi = Url.getInstance().create(UserApi.class);
        Call<User>  usercall  = userApi.getuserdetails(Url.token);

        usercall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                String imagepath = Url.imagePath +response.body().getProfileimage();

                Picasso.get().load(imagepath).into(userprofile);

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

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}


