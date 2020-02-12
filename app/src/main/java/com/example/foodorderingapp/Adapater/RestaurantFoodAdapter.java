package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Activity.OrderActivity;
import com.example.foodorderingapp.Model.Food;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class RestaurantFoodAdapter extends  RecyclerView.Adapter<RestaurantFoodAdapter.RestaurantFoodViewHolder> {

    Context mcontext;
    List<Restuarant> lstresfood;

    public RestaurantFoodAdapter(Context  mcontext, List<Restuarant> lstresfood){
        this.mcontext= mcontext;
        this.lstresfood = lstresfood;
    }



    @NonNull
    @Override
    public RestaurantFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(mcontext).inflate(R.layout.resturantfood,parent,false);
        return new RestaurantFoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantFoodViewHolder holder, int position) {

          final Restuarant resfood = lstresfood.get(position);


         // Food food = resfood.getFoodname();


       // String imagepath = Url.BASE_URL + "uploads/" + food.getFoodimage();
        StrictModeClass.StrictMode();
        try {
           // URL url = new URL(imagepath);
           //holder.restfoodimg.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));

        } catch (Exception e) {

            e.printStackTrace();
        }

        //holder.txtrestfoodprice.setText();


        holder.txtrestfoodname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, OrderActivity.class);
                mcontext.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return lstresfood.size();
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
