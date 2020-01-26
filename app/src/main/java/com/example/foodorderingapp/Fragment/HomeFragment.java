package com.example.foodorderingapp.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodorderingapp.Adapater.ExplorefoodAdapater;
import com.example.foodorderingapp.Adapater.HotDealsAdapater;
import com.example.foodorderingapp.R;

import static com.example.foodorderingapp.Activity.DashboardActivity.lstdeals;
import static com.example.foodorderingapp.Activity.DashboardActivity.lstexfood;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView,rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = v.findViewById(R.id.popular_recyclerview);
        rv = v.findViewById(R.id.popular_recyclerview_hotdeals);

        ExplorefoodAdapater adapater = new ExplorefoodAdapater(getContext(),lstexfood);
        recyclerView.setAdapter(adapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        HotDealsAdapater hotDealsAdapater = new HotDealsAdapater(getContext(),lstdeals);
        rv.setAdapter(hotDealsAdapater);
        rv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        return  v;


    }


}
