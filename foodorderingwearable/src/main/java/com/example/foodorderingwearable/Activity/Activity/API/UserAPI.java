package com.example.foodorderingwearable.Activity.Activity.API;

import com.example.foodorderingwearable.Activity.Activity.Model.User;
import com.example.foodorderingwearable.Activity.Activity.ServerResponse.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {


    @POST("users/signup")
    Call<UserResponse> signup (@Body User user);

    @POST("users/login")
    Call<UserResponse> login (@Body User user);
}
