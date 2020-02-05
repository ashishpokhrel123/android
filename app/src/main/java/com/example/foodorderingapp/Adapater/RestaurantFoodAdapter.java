package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.R;

import java.util.List;

public class RestaurantFoodAdapter extends  RecyclerView.Adapter<RestaurantFoodAdapter.RestaurantFoodViewHolder> {

    Context mcontext;
    List<Food> lstfood;

    public RestaurantFoodAdapter(Context  mcontext, List<Food> lstfood){
        this.mcontext= mcontext;
        this.lstfood = lstfood;
    }



    @NonNull
    @Override
    public RestaurantFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mcontext).inflate(R.layout.resturantfood,parent,false);
        return new RestaurantFoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantFoodViewHolder holder, int position) {

        Food food = lstfood.get(position);
        holder.txtrestfoodname.setText(food.getFoodname());
        holder.txtrestfoodprice.setText(food.getPrice());

    }

    @Override
    public int getItemCount() {
        return lstfood.size();
    }

    public class RestaurantFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView restfoodimg;
        TextView txtrestfoodname,txtrestfoodprice;
        public RestaurantFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            restfoodimg = itemView.findViewById(R.id.restfoodimage);
            txtrestfoodname = itemView.findViewById(R.id.restfoodname);
            txtrestfoodprice = itemView.findViewById(R.id.restfoodprice);
        }
    }
}
