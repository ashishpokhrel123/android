package com.example.foodorderingapp.Model;

import com.google.gson.annotations.SerializedName;

public class Restuarant {
    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private int image;

    public Restuarant(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
