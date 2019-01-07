package com.example.paycalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class ShiftPagerActivity extends AppCompatActivity {


    private static final String EXTRA_TODO_ID = "todo_id";

    private ViewPager mViewPager;
    private List<Shift> mShifts;

    public static Intent newIntent(Context packageContext, UUID todoId){
        Intent intent = new Intent(packageContext, ShiftPagerActivity.class);
        intent.putExtra(EXTRA_TODO_ID, todoId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_pager);

        UUID todoId = (UUID) getIntent().getSerializableExtra(EXTRA_TODO_ID);

        mViewPager = findViewById(R.id.shift_view_pager);

        mShifts = ShiftModel.get(this).getShifts();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Shift shift = mShifts.get(position);
                return ShiftFragment.newInstance(shift.getmId());
            }

            @Override
            public int getCount() {
                return mShifts.size();
            }
        });

        for (int i = 0; i < mShifts.size(); i++){
            if (mShifts.get(i).getmId().equals(todoId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }



    }
}