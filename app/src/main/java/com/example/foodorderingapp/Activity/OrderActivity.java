 package com.example.foodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingapp.R;

public class OrderActivity extends AppCompatActivity {

    ImageView selectitem_image;
    TextView txtdesc,no_of_item,totalprice;
    Button btnincrement,btndecrement,btnaddcart;
     public static float price =120;

    public static int counter = 1;
    public static int c2 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Now");


        selectitem_image = findViewById(R.id.selfoodimg);
        txtdesc = findViewById(R.id.description);
        no_of_item = findViewById(R.id.no_of_items);
        totalprice = findViewById(R.id.totatcost);
        btnincrement = findViewById(R.id.increment);
        btndecrement = findViewById(R.id.decrement);
        btnaddcart = findViewById(R.id.cartbutton);

        btnincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(OrderActivity.this,"Cliked",Toast.LENGTH_SHORT).show();

                if(counter > 0 )
                {
                    counter++;

                    price = price * counter;

                    Toast.makeText(OrderActivity.this,"Price:"+price,Toast.LENGTH_SHORT).show();

                    String count = Integer.toString(counter);

                    no_of_item.setText(count);

                    String totalcost = Float.toString(price);
                    totalprice.setText(totalcost);

                }




            }
        });

        btndecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > 1)
                {
                    counter--;
                    price = price  - (price * counter);

                    String c1 = Integer.toString(counter);
                    no_of_item.setText(c1);

                    String costreduce = Float.toString(price);
                    totalprice.setText(costreduce);

                }



            }
        });

        btnaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addtocart();
            }
        });
    }

    private void addtocart() {
    }
}
