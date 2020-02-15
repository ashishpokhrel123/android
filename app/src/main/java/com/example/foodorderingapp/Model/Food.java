package com.example.foodorderingapp.Model;

public class Food {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String foodname;
    private String foodimage;
    private String price;

    public Food(String id,String foodname, String foodimage, String price) {
        this.id = id;
        this.foodname = foodname;
        this.foodimage = foodimage;
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

