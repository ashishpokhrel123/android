package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.R;

public class RestuarantAdapater extends RecyclerView.Adapter<RestuarantAdapater.RestuarantViewHolder> {

    Context mcontext;


    @NonNull
    @Override
    public RestuarantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RestuarantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RestuarantViewHolder extends RecyclerView.ViewHolder{

        ImageView imgres;
        TextView txtres;

        public RestuarantViewHolder(@NonNull View itemView) {
            super(itemView);
            imgres =itemView.findViewById(R.id.rest_img);
            txtres = itemView.findViewById(R.id.res_text);
        }
    }

}
