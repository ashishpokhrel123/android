package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Fooditem;
import com.example.foodorderingapp.Model.Restuarant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestuarantApi {

    @GET("resturants ")
    Call<List<Restuarant>> getres ();

    @GET("resturants/{id}")
    Call<List<Restuarant>> foodres(@Path("id") String id);

}
