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
    public void setId(UUID id) {
        this.mId = id;
    }

    public String getShiftTitle() {
        return shiftTitle;
    }

    public void setShiftTitle(String title) {
        this.shiftTitle = title;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(int hours) {
        this.shiftHours = hours;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalWorkedHours) {
        this.totalHours = totalWorkedHours;
    }

    public void saveHours (View v)
    {
        totalHours = (totalHours + shiftHours);
    }
}

