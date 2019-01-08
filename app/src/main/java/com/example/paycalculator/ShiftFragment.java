package com.example.paycalculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import java.util.UUID;

public class ShiftFragment extends Fragment {

    private static final String ARG_SHIFT_ID = "shift_id";

    private Shift mShift;
    private EditText mEditTextTitle;
    private EditText mEditTextHours;
    private EditText mEditTextWage;
    private EditText mEditTextTotalPay;
    private Button mCalculatePay;
    private CheckBox mCheckBoxIsComplete;

    /*
    Rather than the calling the constructor directly, Activity(s) should call newInstance
    and pass required parameters that the fragment needs to create its arguments.
     */
    public static ShiftFragment newInstance(UUID shiftId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SHIFT_ID, shiftId);

        ShiftFragment fragment = new ShiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        UUID shiftId = (UUID) getArguments().getSerializable(ARG_SHIFT_ID);

        mShift = ShiftModel.get(getActivity()).getShift(shiftId);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shift, container, false);

        mEditTextTitle = (EditText) view.findViewById(R.id.shift_title);
        mEditTextTitle.setText(mShift.getShiftTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mShift.setShiftTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

/*
        mEditTextHours = (EditText) view.findViewById(R.id.shift_hours);
        mEditTextHours.setText(mShift.getShiftHours());
        mEditTextHours.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mShift.setShiftHours(mEditTextHours);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });

*/


/*
        mCalculatePay = (EditText) view.findViewById(R.id.shift_hours);
        mCalculatePay.setText(mShift.getShiftHours());
        mCalculatePay.setEnabled(false);
*/

/*
        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.shift_complete);
        mCheckBoxIsComplete.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("DEBUG **** ShiftFragment","called onCheckedChanged");
                mShift.setComplete(isChecked);
            }
        });
*/
        return view;

    }
}