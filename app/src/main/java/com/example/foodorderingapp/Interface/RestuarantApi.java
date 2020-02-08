package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Restuarant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RestuarantApi {

    @GET("resturants")
    Call<List<Restuarant>> getres (@Header("Authorization")String token);
}
