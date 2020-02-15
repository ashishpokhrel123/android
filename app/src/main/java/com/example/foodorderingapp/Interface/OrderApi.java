package com.example.foodorderingapp.Interface;

import com.example.foodorderingapp.Model.Cart;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OrderApi {
  @POST("cart")
    Call<Cart> addcart (@Header("Authorization")String token, @Body Cart cart);

}
