package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {

    private String resturant_name;
    private String resturant_address;
     Food food;




    public Restuarant(String resturant_name, String resturant_address, List<Food> lstfood) {
        this.resturant_name = resturant_name;
        this.resturant_address = resturant_address;
        this.food = food;


    }

    public String getResturantname() {
        return resturant_name;
    }

    public void setResturantname(String resturantname) {
        this.resturant_name = resturant_name;
    }

    public String getResturantaddress() {
        return resturant_address;
    }

    public void setResturantaddress(String resturant_address) {
        this.resturant_address = resturant_address;
    }





}
