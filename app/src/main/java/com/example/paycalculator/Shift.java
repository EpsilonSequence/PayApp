package com.example.paycalculator;

import android.view.View;

import java.util.UUID;

public class Shift {
    private UUID mId;
    private String shiftTitle;
    private int shiftHours;
    private int totalHours;

    public Shift() {
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }
    //possible issues
    public void setId(UUID mId) {
        this.mId = mId;
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

    public void saveHours (View v)
    {
        totalHours = (totalHours + shiftHours);
    }
}

