package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {

    private String resturantname;
    private String resturantaddress;
    private  String foodimage;



    public Restuarant(String resturantname, String resturantaddress, String foodimage) {
        this.resturantname = resturantname;
        this.resturantaddress = resturantaddress;
        this.foodimage = foodimage;
    }

    public String getResturantname() {
        return resturantname;
    }

    public void setResturantname(String resturantname) {
        this.resturantname = resturantname;
    }

    public String getResturantaddress() {
        return resturantaddress;
    }

    public void setResturantaddress(String resturantaddress) {
        this.resturantaddress = resturantaddress;
    }


    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage;
    }
}
