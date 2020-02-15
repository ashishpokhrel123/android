package com.example.foodorderingapp.Adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.Model.Cart;
import com.example.foodorderingapp.R;
import com.example.foodorderingapp.URL.Url;

import java.util.List;

public class CartAdapater  extends  RecyclerView.Adapter<CartAdapater.CartViewHolder>{

    Context mcontext;
    List<Cart> lstcart;

    public CartAdapater(Context mcontext,List<Cart> lstcart){
        this.mcontext = mcontext;
        this.lstcart = lstcart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.order_details,parent,false);
        return new CartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        Cart cart = lstcart.get(position);

        //String imagepath = Url.BASE_URL +"uploads" +lstorder.get(position).;



        holder.txtfoodname.setText(cart.getFood());

    }

    @Override
    public int getItemCount() {
        return lstcart.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtfoodname;
        Button btndel, bthupd;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.orderfoodimage);
            txtfoodname = itemView.findViewById(R.id.orderfoodname);
            bthupd = itemView.findViewById(R.id.btnupdate);
            btndel = itemView.findViewById(R.id.btndelete);
        }
    }
}
