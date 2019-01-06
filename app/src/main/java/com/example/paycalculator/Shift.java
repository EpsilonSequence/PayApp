package com.example.paycalculator;

import android.view.View;

import java.util.UUID;

public class Shift {
    private UUID shiftId;
    private String shiftTitle;
    private String mDetail;
    private int mHours;
    private int totalHours;

    public Shift() {
        shiftId = UUID.randomUUID();
    }

    public UUID getShiftId() {
        return shiftId;
    }

    public void setShiftId(UUID shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftTitle() {
        return shiftTitle;
    }

    public void setShiftTitle(String shiftTitle) {
        this.shiftTitle = shiftTitle;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    public int getmHours() {
        return mHours;
    }

    public void setmHours(int mHours) {
        this.mHours = mHours;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void saveHours (View v)
    {
        totalHours = (totalHours + mHours);
    }
}

