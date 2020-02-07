package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {

    private String resturantname;
    private String resturantaddress;







    public Restuarant(String resturantname, String resturantaddress) {
        this.resturantname = resturantname;
        this.resturantaddress = resturantaddress;

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





}
