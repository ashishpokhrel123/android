package com.example.foodordering_wear;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class WatchAdapter extends  RecyclerView.Adapter<WatchAdapter.WatchAdapterViewHolder> {

    Context mContext;
    List<Food> lstpopcategory;

    public WatchAdapter(Context mContext, List<Food>lstpopcategory)
    {
        this.mContext = mContext;
        this.lstpopcategory = lstpopcategory;
    }


    @NonNull
    @Override
    public WatchAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.watchapi,parent,false);
        return new WatchAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchAdapterViewHolder holder, int position) {
        Food food = lstpopcategory.get(position);

        String imagepath = Url.BASE_URL+ "uploads/" + lstpopcategory.get(position).getFoodimage();
        StrictMode.StrictMode();
        try {
            URL url=new URL(imagepath);
            holder.image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }


    }




    @Override
    public int getItemCount() {
        return 0;
    }

    public class WatchAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public WatchAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.popular_img);
        }
    }
}
