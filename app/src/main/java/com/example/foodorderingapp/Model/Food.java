package com.example.foodorderingapp.Model;

public class Food {
    private String foodname;
    //private String foodimage;
    private String price;
    private String resturant;
    private String order;

    public Food(String foodname, String price, String resturant, String order) {
        this.foodname = foodname;
        //this.foodimage = foodimage;
        this.price = price;
        this.resturant = resturant;
        this.order = order;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getResturant() {
        return resturant;
    }

    public void setResturant(String resturant) {
        this.resturant = resturant;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
