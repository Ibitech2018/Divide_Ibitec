package com.divide.ibitech.divide_ibitech;


import android.support.v7.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.graphics.Color;


public class Request extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Boolean valid;
         String dName,p_Name,date;
         EditText DName, PName;
         TextView Date ,tRequest;
    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mDisplayDate = (TextView) findViewById(R.id.Date);

        DName= findViewById(R.id.et_Device);
        PName= findViewById(R.id.tv_Pracitioner);
        Date= findViewById(R.id.Date);
        tRequest=findViewById(R.id.tRequest);
        tRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        //Device name
        DName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (DName.getText().length()<8)
                {
                    DName.setError("Please enter valid Device");
                }
            }
        });

        PName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (PName.getText().length()<8)
                {
                    PName.setError("Please enter valid Practitioner");
                }
            }
        });
        Date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (Date.getText().length()<5)
                {
                    Date.setError("Please Select  a valid Date");
                }
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Request.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };


    }
    public  void openDialog(){

        requestDialog requestDialog= new  requestDialog();
        requestDialog.show(getSupportFragmentManager(),"requestDialog");
    }


}
