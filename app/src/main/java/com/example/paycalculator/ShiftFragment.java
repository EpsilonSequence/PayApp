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
    private Button mButtonDate;
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

        /*
         Fragment accessing the intent from the hosting Activity as in the following code snippet
         allows for simple code that works.

        UUID shiftId = (UUID) getActivity()
                .getIntent().getSerializableExtra(TodoActivity.EXTRA_SHIFT_ID);

         The disadvantage: ShiftFragment is no longer reusable as it is coupled to Activities whoes
         intent has to contain the shiftId.

         Solution: store the shiftId in the fragment's arguments bundle.
            See the ShiftFragment newInstance(UUID shiftId) method.

         Then to create a new fragment, the TodoActivity should call ShiftFragment.newInstance(UUID)
         and pass in the UUID it retrieves from its extra argument.

        */

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
                // This line is intentionally left blank
            }
        });

        /*
        mEditTextTitle = (EditText) view.findViewById(R.id.shift_hours);
        mEditTextTitle.setText(mShift.getShiftHours());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mShift.setShiftHours((String.valueOf(sh)));
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This line is intentionally left blank
            }
        });




/*
        mButtonDate = (EditText) view.findViewById(R.id.shift_hours);
        mButtonDate.setText(mShift.getShiftHours());
        mButtonDate.setEnabled(false);
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