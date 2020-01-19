package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.PopCategory;
import com.example.foodorderingapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PopularCategory extends  RecyclerView.Adapter<PopularCategory.PopularCategoryViewHolder> {

    Context mContext;
    List<PopCategory> lstpopcategory;

    public PopularCategory(Context mContext, List<PopCategory>lstpopcategory)
    {
        this.mContext = mContext;
        this.lstpopcategory = lstpopcategory;
    }



    @NonNull
    @Override
    public PopularCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.popular_categories,parent,false);
        return new PopularCategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularCategoryViewHolder holder, int position) {
        PopCategory pc = lstpopcategory.get(position);
        holder.image.setImageResource(pc.getCateimg());
        holder.txtcatename.setText(pc.getCarename());
    }



    @Override
    public int getItemCount() {
        return lstpopcategory.size();
    }

    public class PopularCategoryViewHolder extends RecyclerView.ViewHolder
    {
       CircleImageView image;
       TextView txtcatename;

        public PopularCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.cimage);
            txtcatename = itemView.findViewById(R.id.catename);
        }
    }

}
