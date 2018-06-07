package com.divide.ibitech.divide_ibitech;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.graphics.Color;

import static com.divide.ibitech.divide_ibitech.R.id.etDevice;


public class Request extends AppCompatActivity {
    private EditText DeviceName, practitionerName, setDate;
    private TextInputLayout inputLayoutName, inputLayoutpractitioner, inputLayoutDate;
    private Button btnRequest;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Boolean valid;
    String dName, p_Name, date;
    EditText DName, PName;
    ImageButton viewR;
    TextView Date, tRequest;
    public String subject;
    public String message;
    public String to;

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        message = "You have Successfully Requested Medical Device \n You can see the status of Device on the IbetchApp";
        subject = "@NoReply";
        to = "slabiti181@gmail.com";
        DName=findViewById(R.id.etDevice);
        PName=findViewById(R.id.eet_Pracitioner);
        Date=findViewById(R.id.Date1);
        mDisplayDate = (TextView) findViewById(R.id.Date1);
        tRequest = findViewById(R.id.tRequest);
        viewR= findViewById(R.id.viewR);
viewR.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
openRequest();
    }
});
        tRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //everything is filled out
                //send email
                new SimpleMail().sendEmail(to, subject, message);
                next();
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Request.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
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
    public void next() {
        initialize();
        if (!Validate()) {
            Toast.makeText(this, "Cannot Proceed Data Missing Or Invalid Data Input", Toast.LENGTH_SHORT).show();
        } else {
          openDialog();
        }
    }
    public boolean Validate() {
        boolean valid = true;
        if (dName.isEmpty() || dName.length() > 13) {
            DName.setError("Please Enter Valid ID Number");
            valid = false;
        }

        if (p_Name.isEmpty() || p_Name.length() > 10) {
            PName.setError("Please Enter Valid CellNumber");
            valid = false;
        }

        if (date.isEmpty()) {
            Date.setError("Please Enter Valid CellNumber");
            valid = false;
        }



        return valid;
    }
    public void initialize() {
        //*********Passing data to new variables************
        dName = DName.getText().toString().trim();
        p_Name = PName.getText().toString().trim();
        date = Date.getText().toString().trim();

    }

    public void openDialog() {

        requestDialog requestDialog = new requestDialog();
        requestDialog.show(getSupportFragmentManager(), "requestDialog");
    }
    private void openRequest() {
        Intent intent = new Intent(this, Requestview.class);
        startActivity(intent);
    }
}
