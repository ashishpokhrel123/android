package com.example.foodordering_wear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashbaordActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ImageView img;
    TextView txttoken;

    public static  List<Food> lstfoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Bundle bundle = getIntent().getExtras();
        String resid = bundle.getString("token");


        txttoken.setText(resid);


        //textView = findViewById(R.id.txtname);



    }
}
