package com.example.paycalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

public class ShiftActivity extends AppCompatActivity {


    public static final String EXTRA_SHIFT_ID = "shift_id";

    public static Intent newIntent(Context packageContext, UUID shiftId) {
        Intent intent = new Intent(packageContext, ShiftActivity.class);
        intent.putExtra(EXTRA_SHIFT_ID, shiftId);
        return intent;
    }

    /*
    To decouple the fragment and make it reusable, the ShiftFragment has a newInstance method
    that receives a shiftId and returns the fragment
     */
    protected Fragment createFragment(){
        UUID shiftId = (UUID) getIntent().getSerializableExtra(EXTRA_SHIFT_ID);
        return ShiftFragment.newInstance(shiftId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){

            Fragment shiftFragment = createFragment();

            fm.beginTransaction()
                    .add(R.id.fragment_container, shiftFragment)
                    .commit();
        }

    }

}