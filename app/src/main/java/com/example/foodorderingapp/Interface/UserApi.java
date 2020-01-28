package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.User;
import com.example.foodorderingapp.ServerResponse.ImageResponse;
import com.example.foodorderingapp.ServerResponse.UserResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserApi {

    @POST("users/signup")
    Call<Void> signup (@Body User user);

    @POST("users/login")
    Call<UserResponse> login (@Body User user);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadimage(@Part MultipartBody.Part img);
}
