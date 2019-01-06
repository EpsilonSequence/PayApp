package com.example.paycalculator;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class ShiftModel {

    private static ShiftModel sShiftModel;

    private ArrayList<Shift> shiftList;

    public static ShiftModel get(Context context) {
        if (sShiftModel == null) {
            sShiftModel = new ShiftModel(context);
        }
        return sShiftModel;
    }

    private ShiftModel(Context context){
        shiftList = new ArrayList<>();

        // refactor to pattern for data plugins
        // simulate some data for testing

        for (int i=0; i < 3; i++){
            Shift shift = new Shift();
            shift.setShiftTitle("Shift title " + i);
            //shift.setDetail("Detail for task " + shift.getId().toString());

            shiftList.add(shift);
        }

    }

    public Shift getShift(UUID shiftId) {

        for (Shift shift : shiftList) {
            if (shift.getmId().equals(shiftId)){
                return shift;
            }
        }

        return null;
    }

    public ArrayList<Shift> getShifts() {

        return shiftList;

    }

    public void addShift(Shift shift){

        shiftList.add(shift);

    }

}