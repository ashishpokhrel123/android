package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.HotDeals;
import com.example.foodorderingapp.R;

import java.util.List;

public class HotDealsAdapater extends  RecyclerView.Adapter<HotDealsAdapater.PopularCategoryViewHolder> {

    Context mContext;
    List<HotDeals> lstpopcategory;

    public HotDealsAdapater(Context mContext, List<HotDeals>lstpopcategory)
    {
        this.mContext = mContext;
        this.lstpopcategory = lstpopcategory;
    }



    @NonNull
    @Override
    public PopularCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hot_deals,parent,false);
        return new PopularCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCategoryViewHolder holder, int position) {
        HotDeals pc = lstpopcategory.get(position);
        holder.image.setImageResource(pc.getCateimg());

    }



    @Override
    public int getItemCount() {
        return lstpopcategory.size();
    }

    public class PopularCategoryViewHolder extends RecyclerView.ViewHolder
    {
       ImageView image;


        public PopularCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.hot_dealsimg);

        }
    }

}
