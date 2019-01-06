package com.example.paycalculator;

import java.util.UUID;

public class Shift {
    private UUID shiftId;
    private String mTitle;
    private String mDetail;
    private int mHours;

    public Shift() {
        shiftId = UUID.randomUUID();
    }

}

