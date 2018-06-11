package com.divide.ibitech.divide_ibitech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class Request extends AppCompatActivity {


    private EditText DeviceName, practitionerName, setDate;
    private TextInputLayout inputLayoutName, inputLayoutpractitioner, inputLayoutDate;
    private Button btnRequest;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Boolean valid;
    String dName, p_Name, date;
    EditText DName, PName;
    ImageButton viewR;
    TextView Date, tRequest ,statusR;
    public String subject;
    public String message;
    public String to;
    public String deviceStatus;
    String [] names = {"Request Device"};
    String [] status = {"Device Requested"};
    ArrayAdapter<String > adapter;
    Spinner sp;
    public String DeviceStatus;

    private static final String TAG = "MainActivity";

    private TextView mDisplayDate ,Views;


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
        sp= (Spinner)findViewById(R.id.Spin);
        statusR = (TextView)findViewById(R.id.statusRequest);
        Calendar calendar= Calendar.getInstance();
        String currrentDate= DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
        Date.setText(currrentDate);
        Views= (TextView)findViewById(R.id.Views);
        mDisplayDate = (TextView) findViewById(R.id.Date1);
        tRequest = findViewById(R.id.tRequest);








    }
}
