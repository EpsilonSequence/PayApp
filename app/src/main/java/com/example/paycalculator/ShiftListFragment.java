package com.example.paycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShiftListFragment extends Fragment {

    private RecyclerView mShiftRecyclerView;
    ShiftAdapter mShiftAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shift_list, container, false);

        mShiftRecyclerView = (RecyclerView) view.findViewById(R.id.shift_recycler_view);
        mShiftRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()) );

        updateUI();

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_shift_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_shift:

                Shift shift = new Shift();
                ShiftModel.get(getActivity()).addShift(shift);

                Intent intent = ShiftPagerActivity.newIntent(getActivity(), shift.getmId());
                startActivity(intent);

                return true;

            case R.id.calculate_pay:

                Calculator calculator = new Calculator();
                ShiftModel.get(getActivity()).addCalculator(calculator);

                intent = ShiftPagerActivity.newIntent(getActivity(), calculator.getcalcId());
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI(){

        ArrayList shifts = new ArrayList<>();
        ShiftModel shiftModel = ShiftModel.get(getContext());
        shifts = shiftModel.getShifts();

        if (mShiftAdapter == null) {
            mShiftAdapter = new ShiftAdapter(shifts);
            mShiftRecyclerView.setAdapter(mShiftAdapter);
        } else {
            mShiftAdapter.notifyDataSetChanged();
        }

    }

    public class ShiftHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Shift mShift;
        private TextView mTextViewTitle;
        private TextView mTextViewHours;

        public ShiftHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.list_item_shift, parent, false));

            itemView.setOnClickListener(this);

            mTextViewTitle = (TextView) itemView.findViewById(R.id.shift_title);
            mTextViewHours = (TextView) itemView.findViewById(R.id.shift_title);

        }

        @Override
        public void onClick(View view) {
            // have a Toast for now
            Toast.makeText(
                    getActivity(),
                    mShift.getShiftTitle() + " clicked",
                    Toast.LENGTH_SHORT)
                    .show();

            Intent intent = ShiftActivity.newIntent(getActivity(), mShift.getmId());
            startActivity(intent);

        }

        public void bind(Shift shift){
            mShift = shift;
            mTextViewTitle.setText(mShift.getShiftTitle());
            //mTextViewHours.setText(mShift.getShiftHours());
        }

    }

    public class ShiftAdapter extends RecyclerView.Adapter<ShiftListFragment.ShiftHolder> {

        private List<Shift> mShifts;

        public ShiftAdapter(List<Shift> shifts) {
            mShifts = shifts;
        }

        @Override
        public ShiftListFragment.ShiftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ShiftHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ShiftHolder holder, int position) {
            Shift shift = mShifts.get(position);
            holder.bind(shift);
        }

        @Override
        public int getItemCount() {
            return mShifts.size();
        }

    }
}