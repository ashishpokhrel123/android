package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {

    @POST("/users/signup")
    Call<Void> signup (@Body User user);

    @POST("users/login")
    Call<Void> login (@Body User user);
}
