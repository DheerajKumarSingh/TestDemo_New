package com.example.dheeraj.testdemo.range_picker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.dheeraj.testdemo.R;

/**
 * Created by DHEERAJ on 8/28/2017.
 */

public class Activity_Range_Picker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_picker);
        Alert_Show_Range();
    }


    AlertDialog alertDialog;
     TextView tv_set,tvcancel;

    private void Alert_Show_Range() {
        AlertDialog.Builder alertbuilder = new AlertDialog.Builder(Activity_Range_Picker.this);
        LayoutInflater layoutInflater = LayoutInflater.from(Activity_Range_Picker.this);
        View view = layoutInflater.inflate(R.layout.alert_range_picker, null);
        alertbuilder.setView(view);
        alertDialog = alertbuilder.create();
        alertDialog.show();
        final NumberPicker np1 = (NumberPicker) view.findViewById(R.id.np);
        final NumberPicker np2 = (NumberPicker) view.findViewById(R.id.np2);
        tv_set=(TextView)view.findViewById(R.id.tv_set);
        tvcancel=(TextView) view.findViewById(R.id.tvcancel);


        // setup default value
        String[] numbers = new String[100];
        for(int i =0 ; i < 100 ; i++) {
            numbers[i] = i + "";
        }
        np1.setMaxValue(100);
        np1.setMinValue(1);
        np1.setDisplayedValues(numbers);
        np1.setValue(18);
        String[] numbers2 = new String[100];
        for(int i =0 ; i < 100 ; i++) {
            numbers2[i] = i + "";
        }
        np2.setMaxValue(100);
        np2.setMinValue(1);
        np2.setDisplayedValues(numbers2);
        np2.setValue(30);



        tv_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("nap1",""+np1.getValue());
                Log.v("nap2",""+np2.getValue());
                alertDialog.dismiss();

            }
        });

        tvcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("nap1",""+np1.getValue());
                Log.v("nap2",""+np2.getValue());
                alertDialog.dismiss();
            }
        });

        //  tv.setTextColor(Color.parseColor("#ffd32b3b"));
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.v("newVal", "" + newVal);


            }
        });
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.v("newVal2", "" + newVal);
            }
        });
    }
}
