package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {

    private String resturant_name;
    private String resturant_address;
    private String res_image;


    public String getRes_image() {
        return res_image;
    }

    public void setRes_image(String res_image) {
        this.res_image = res_image;
    }

    public Restuarant(String resturant_name, String resturant_address, String res_image) {
        this.resturant_name = resturant_name;
        this.resturant_address = resturant_address;
        this.res_image = res_image;

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
