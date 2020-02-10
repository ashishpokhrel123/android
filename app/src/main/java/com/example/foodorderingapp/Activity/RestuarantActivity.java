package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.RestuarantAdapater;
import com.example.foodorderingapp.Interface.RestuarantApi;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.foodorderingapp.Activity.DashboardActivity.lstres;

public class RestuarantActivity extends AppCompatActivity {

    TextView txtname;

    public static List<Restuarant> lstrest;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant);

        getSupportActionBar().hide();
        rv = findViewById(R.id.recycler_allresturant);



        lstrest = new ArrayList<>();


        getRestuarant();





    }

    private void getRestuarant()
    {
        RestuarantApi restuarantApi = Url.getInstance().create(RestuarantApi.class);
        Call<List<Restuarant>> restuarantCall = restuarantApi.getres(Url.token);


        restuarantCall.enqueue(new Callback<List<Restuarant>>() {
            @Override
            public void onResponse(Call<List<Restuarant>> call, Response<List<Restuarant>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(RestuarantActivity.this,"Error"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                lstrest = response.body();

            }

            @Override
            public void onFailure(Call<List<Restuarant>> call, Throwable t) {

            }
        });

        RestuarantAdapater radapter = new RestuarantAdapater(RestuarantActivity.this,lstrest);
        rv.setAdapter(radapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
