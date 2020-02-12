package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Activity.ViewResturantFoodActivity;
import com.example.foodorderingapp.Model.Restuarant;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;
import com.example.foodorderingapp.strictmode.StrictModeClass;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AllResturantAdapter extends RecyclerView.Adapter<AllResturantAdapter.AllResturantViewHolder> {

    Context mcontext;
    List<Restuarant> lstres;

    public AllResturantAdapter(Context mcontext,List<Restuarant> lstres){
        this.mcontext= mcontext;
        this.lstres= lstres;
    }


    @NonNull
    @Override
    public AllResturantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.foodavailable,parent,false);
        return new AllResturantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllResturantViewHolder holder, final int position) {


          final Restuarant res = lstres.get(position);

       String imagepath = Url.BASE_URL +"uploads" +lstres.get(0).getRes_image();
       //String rename = lstres.get(position).getRes_image();
         StrictModeClass.StrictMode();

         String id = res.getId();

           try {
              URL url=new URL(imagepath);
            holder.resimage.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));


        } catch (Exception e) {

        }

        holder.txtname.setText(res.getResturantname());
           holder.txtname.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {


                   Intent i = new Intent(mcontext, ViewResturantFoodActivity.class);
                   i.putExtra("id",res.getId());
                   mcontext.startActivity(i);
               }
           });

    }

    @Override
    public int getItemCount() {
        return lstres.size();
    }

    public class AllResturantViewHolder extends RecyclerView.ViewHolder{
        ImageView resimage;
        TextView txtname,txtaddress,txtinfo,txtstatus;

        public AllResturantViewHolder(@NonNull View itemView) {
            super(itemView);

            resimage = itemView.findViewById(R.id.food_img);
            txtname = itemView.findViewById(R.id.rest_name);
            txtaddress = itemView.findViewById(R.id.rest_name);
            txtinfo = itemView.findViewById(R.id.rest_address);
            txtstatus = itemView.findViewById(R.id.rest_status);

        }
    }
}
