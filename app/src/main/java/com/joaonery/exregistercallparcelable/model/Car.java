package com.joaonery.exregistercallparcelable.model;

import android.content.Context;

import com.joaonery.exregistercallparcelable.R;

public class Car {

    private String model;
    private String brand;
    private int year;
    private Context context;

    public Car(Context context) {
        this.context = context;
    }

    public Car(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  context.getResources().getString(R.string.ra_et_model) + ": " + model + "\n" +
                context.getResources().getString(R.string.ra_tv_brand) + ": " + brand + "\n" +
                context.getResources().getString(R.string.ra_et_year) + ": " + year;
    }
}
