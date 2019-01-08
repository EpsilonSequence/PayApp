package com.example.paycalculator;

import android.view.View;

import java.util.UUID;

public class Calculator {
    private UUID calcId;
    private String shiftTitle;
    private int shiftHours;
    private int totalHours;
    private double hourlyWage;
    private double totalPay;

    public Calculator() {
        calcId = UUID.randomUUID();
    }

    public UUID getcalcId() {
        return calcId;
    }

    public void setcalcId(UUID calcId) {
        this.calcId = calcId;
    }

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

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
}