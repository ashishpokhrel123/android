package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.Adapater.CartAdapater;
import com.example.foodorderingapp.Interface.OrderApi;
import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

           Toolbar toolbar;
           RecyclerView recyclerView;
           TextView txtprice;
            List<Cart> lstcart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = findViewById(R.id.cart_toolbar);
        recyclerView = findViewById(R.id.recycler_cart);
        txtprice = findViewById(R.id.final_price);
        recyclerView = findViewById(R.id.recycler_cart);

        lstcart = new ArrayList<>();

        lstcart.add(new Cart("78908646rtfi7585999","Fries","2","300"));


        vieworderfood();
    }

    private void vieworderfood() {

        OrderApi orderApi = Url.getInstance().create(OrderApi.class);
        Call<Cart> cartCall = orderApi.getcart(Url.token);
        cartCall.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {

            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {

            }
        });

    }
}
