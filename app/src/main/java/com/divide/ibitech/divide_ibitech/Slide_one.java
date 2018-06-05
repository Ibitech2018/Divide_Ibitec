package com.divide.ibitech.divide_ibitech;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.tech.NfcA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Slide_one extends AppCompatActivity {
    // Variable to store  data from previous activity//String userID,userCellNo,userMail,userPass,userCPassword;
    //End
    Button nextSlide;
    RadioButton Gender;
    EditText Name,Surname,DateOfBirth,Address,Suburb,City,PostalCode;
    String name,surname,date,gender,address,suburb,city,code;
    AlertDialog.Builder builder;
    // String url="http://sict-iis.nmmu.ac.za/Ibitech/app/Register.php";
    ImageView top;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_one);
        Name=(EditText) findViewById(R.id.Fname);
        Surname=(EditText) findViewById(R.id.Surname);
        DateOfBirth=(EditText) findViewById(R.id.Dob);
        // Gender=(RadioButton) findViewById(R.id.Gender);
        Address=(EditText) findViewById(R.id.address1);
        Suburb=(EditText) findViewById(R.id.suburb);
        City=(EditText) findViewById(R.id.City);
        PostalCode=(EditText) findViewById(R.id.postalCode);
        //retrive  dara from 1st form
        //  userID = (getIntent().getStringExtra("IDNumber"));
        // userCellNo = (getIntent().getStringExtra("CellNumber"));
        //  userMail = (getIntent().getStringExtra("Email_Address"));
        // userPass = (getIntent().getStringExtra("Password"));
        // userCPassword = (getIntent().getStringExtra("ConfirmPassword"));
        //End


        //   SharedPreferences preferences= getSharedPreferences("MYP",MODE_PRIVATE);
        //   String displayLog= preferences.getString("display","");

        nextSlide = findViewById(R.id.btnNext);


        nextSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });


        builder = new AlertDialog.Builder(Slide_one.this);
    }
    public void next() {
        initialize();
        if (!Validate()) {
            Toast.makeText(this, "Cannot Proceed Data Missing Or Invalid Data Input", Toast.LENGTH_SHORT).show();
        } else {
            nextSuccess();
        }
    }
    public  void  nextSuccess(){
        SharedPreferences preferences = getSharedPreferences("MYP",MODE_PRIVATE);
        name=Name.getText().toString();
        surname=Surname.getText().toString();
        String userReg=preferences.getString(name+surname+"data",name+""+surname);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(name + "data", name);
        editor.putString(surname + "data", surname);
        editor.putString("display", userReg);
        editor.commit();

        Intent intent = new Intent(this, Slide_two.class);
        intent.putExtra("Firstname", name);
        intent.putExtra("Surname", surname);
        intent.putExtra("DateOfBirth", date);
        intent.putExtra("Address", address);
        intent.putExtra("Suburb", suburb);
        intent.putExtra("City", city);
        intent.putExtra("PostalCode", code);
        startActivity(intent);


    }

    //Validate user input
    public boolean Validate() {
        boolean valid = true;
        if (name.isEmpty() || name.length() > 13) {
            Name.setError("Please Enter Valid ID Number");
            valid = false;
        }




        return valid;
    }
    public void initialize() {
        //*********Passing data to new variables************




    }

    public void displayAlert(final String code) {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (code.equals("input_error")) {
                    Name.setText("");
                    Surname.setText("");
                    Address.setText("");
                    Suburb.setText("");
                    City.setText("");
                    PostalCode.setText("");

                } else if (code.equals("reg_success")) {
                    Intent intent = new Intent(Slide_one.this, Login.class);
                    startActivity(intent);
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}

