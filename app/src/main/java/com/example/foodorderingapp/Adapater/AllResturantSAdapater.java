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

public class AllResturantSAdapater extends RecyclerView.Adapter<AllResturantSAdapater.AllResturantSViewHolder> {

    Context mcontext;
    List<Restuarant> lstres;

    public AllResturantSAdapater(Context mcontext,List<Restuarant> lstres){
        this.mcontext=mcontext;
        this.lstres=lstres;
    }


    @NonNull
    @Override
    public AllResturantSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.foodavailable,parent,false);
        return new AllResturantSViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AllResturantSViewHolder holder, int position) {


        Restuarant res = lstres.get(position);

        String imagepath = Url.BASE_URL +"uploads/" + lstres.get(position).getRes_image();
        String re8sname = lstres.get(position).getResturantname();
        StrictModeClass.StrictMode();


        try {
            URL url=new URL(imagepath);
            holder.resimage.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {

        }
        holder.resname.setText(re8sname);

    }

    @Override
    public int getItemCount() {
        return lstres.size();
    }

    public class AllResturantSViewHolder extends RecyclerView.ViewHolder{

        ImageView resimage;
        TextView resname,resaddress,resinfo,resstatus;

        public AllResturantSViewHolder(@NonNull View itemView) {
            super(itemView);

            resimage = itemView.findViewById(R.id.food_img);
            resname = itemView.findViewById(R.id.rest_name);
            resaddress = itemView.findViewById(R.id.rest_address);
            resinfo = itemView.findViewById(R.id.rest_info);
            resstatus = itemView.findViewById(R.id.rest_status);

        }
    }
}
