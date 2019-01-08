package com.example.paycalculator;

import android.view.View;

import java.util.UUID;

public class Calculator {
    private UUID mId;
    private String shiftTitle;
    private int shiftHours;
    private int totalHours;
    private double hourlyWage;
    private double totalPay;


    public String getShiftTitle() {
        return shiftTitle;
    }

    public void setShiftTitle(String shiftTitle) {
        this.shiftTitle = shiftTitle;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void saveHours (View v)
    {
        totalHours = (totalHours + shiftHours);
    }
}