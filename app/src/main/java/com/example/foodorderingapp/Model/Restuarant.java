package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restuarant {
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    private String _id;
    private String resturant_name;
    private String resturant_address;


    public String getRes_image() {
        return res_image;
    }

    public void setRes_image(String res_image) {
        this.res_image = res_image;
    }

    private String res_image;

    public Food getFooditem() {
        return fooditem;
    }

    public void setFooditem(Food fooditem) {
        this.fooditem = fooditem;
    }

    Food  fooditem;














    public Restuarant(String _id,String resturant_name, String resturant_address) {
        this._id = _id;
        this.resturant_name = resturant_name;
        this.resturant_address = resturant_address;



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
