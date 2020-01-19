package com.example.foodorderingapp.Model;

public class PopCategory {
    private int cateimg;
    private String carename;

    public PopCategory(int cateimg, String carename) {
        this.cateimg = cateimg;
        this.carename = carename;
    }

    public int getCateimg() {
        return cateimg;
    }

    public void setCateimg(int cateimg) {
        this.cateimg = cateimg;
    }

    public String getCarename() {
        return carename;
    }

    public void setCarename(String carename) {
        this.carename = carename;
    }
}
