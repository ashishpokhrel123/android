package com.example.foodorderingapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderingapp.Activity.CartActivity;
import com.example.foodorderingapp.Activity.FoodActivity;
import com.example.foodorderingapp.Activity.RestuarantActivity;
import com.example.foodorderingapp.Adapater.ExplorefoodAdapater;
import com.example.foodorderingapp.Adapater.HotDealsAdapater;
import com.example.foodorderingapp.Adapater.PopularAdapater;
import com.example.foodorderingapp.Adapater.RestuarantAdapater;
import com.example.foodorderingapp.R;

import static com.example.foodorderingapp.Activity.DashboardActivity.lstdeals;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstexfood;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstpop;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstres;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView,rv,recyclerView_res,rv_popular;

    private TextView txtviewresturant;

    private ImageView cartimage;

    private Button btnviewresturant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

         //txtviewresturant = v.findViewById(R.id.viewrestuarnt);
         btnviewresturant = v.findViewById(R.id.viewrestuarnt);

        recyclerView = v.findViewById(R.id.popular_recyclerview);
        rv = v.findViewById(R.id.popular_recyclerview_hotdeals);
        recyclerView_res = v.findViewById(R.id.recycler_restuarnt);
        rv_popular = v.findViewById(R.id.recycler_populattoday);
        cartimage = v.findViewById(R.id.cartlist);

        ExplorefoodAdapater adapater = new ExplorefoodAdapater(getContext(),lstexfood);
        recyclerView.setAdapter(adapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        HotDealsAdapater hotDealsAdapater = new HotDealsAdapater(getContext(),lstdeals);
        rv.setAdapter(hotDealsAdapater);
        rv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        RestuarantAdapater restuarantAdapater = new RestuarantAdapater(getContext(),lstres);
        recyclerView_res.setAdapter(restuarantAdapater);
        recyclerView_res.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        PopularAdapater popularAdapater = new PopularAdapater(getContext(),lstpop);
        rv_popular.setAdapter(popularAdapater);
        rv_popular.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


       btnviewresturant.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getContext(), FoodActivity.class);
               startActivity(i);
           }
       });





        return  v;


    }


}
