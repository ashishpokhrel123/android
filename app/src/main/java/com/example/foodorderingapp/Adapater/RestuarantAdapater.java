package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class RestuarantAdapater extends RecyclerView.Adapter<RestuarantAdapater.RestuarantViewHolder> {

    Context mcontext;
    List<Restuarant> lstres;

    public RestuarantAdapater(Context mcontext,List<Restuarant> lstres){
        this.mcontext=mcontext;
        this.lstres=lstres;
    }


    @NonNull
    @Override
    public RestuarantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.resturant,parent,false);
        return new RestuarantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestuarantViewHolder holder, int position) {

        Restuarant res = lstres.get(position);

        String imagepath = Url.BASE_URL +"uploads/" + lstres.get(position).getFoodimage();

        StrictModeClass.StrictMode();
        try {
            URL url=new URL(imagepath);
            holder.imgres.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return lstres.size();
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
