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
import android.widget.Toast;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.graphics.Color;


public class Request extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Boolean valid;
         String dName,p_Name,date;
         EditText DName, PName;
         TextView Date ,tRequest;
    public  String subject;
    public  String message;
    public  String to;

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mDisplayDate = (TextView) findViewById(R.id.Date);
        message="You have Successfully Requested Medical Device \n You can see the status of Device on the IbetchApp";
        subject="@NoReply";
        to="slabiti181@gmail.com";

        DName= findViewById(R.id.et_Device);
        PName= findViewById(R.id.tv_Pracitioner);
        Date= findViewById(R.id.Date);
        tRequest=findViewById(R.id.tRequest);
        tRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(to.isEmpty()){
                        Toast.makeText(Request.this, "You must enter a recipient email", Toast.LENGTH_LONG).show();
                    }else if(subject.isEmpty()){
                        Toast.makeText(Request.this, "You must enter a Subject", Toast.LENGTH_LONG).show();
                    }else if(message.isEmpty()){
                        Toast.makeText(Request.this, "You must enter a message", Toast.LENGTH_LONG).show();
                    }else {
                        //everything is filled out
                        //send email
                        new SimpleMail().sendEmail(to, subject, message);
                        openDialog();
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                  }




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
