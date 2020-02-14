package com.example.foodordering_wear;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {

    @POST("users/login")
    Call<UserResponse> login (@Body User user);
}
