package com.divide.ibitech.divide_ibitech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class Dashboard extends AppCompatActivity {

    TextView tv_FullName, tv_Age, tv_BloodType, tv_Address,tv_Gender,tv_MaritalStatus;
    ImageView img_ProfilePic;
    Button btn_Logout;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        tv_FullName = findViewById(R.id.tvName);
        tv_Age = findViewById(R.id.age);
        tv_BloodType = findViewById(R.id.bloodType);
        tv_Address = findViewById(R.id.tvAddress);
        tv_Gender = findViewById(R.id.gender);
        tv_MaritalStatus = findViewById(R.id.maritalStatus);

        img_ProfilePic = findViewById(R.id.imgProfilePic);

        btn_Logout = findViewById(R.id.btnLogout);

        HashMap<String,String> user = sessionManager.getUserDetails();
        String sName = user.get(sessionManager.NAME);
        String sSurname = user.get(sessionManager.SURNAME);
        String sAge = user.get(sessionManager.AGE);
        String sBloodType = user.get(sessionManager.BLOODTYPE);
        String sGender = user.get(sessionManager.GENDER);
        String sStatus = user.get(sessionManager.STATUS);
        String sAddress = user.get(sessionManager.ADDRESS);

        tv_FullName.setText(sName + " " + sSurname);
        tv_Age.setText(sAge);
        tv_BloodType.setText(sBloodType);
        tv_Gender.setText(sGender);
        tv_MaritalStatus.setText(sStatus);
        tv_Address.setText(sAddress);
        LinearLayout device = findViewById(R.id.manageCondition);

     device.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             OpenRequest();
         }
     });
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.aya);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        img_ProfilePic.setImageDrawable(roundedBitmapDrawable);

    }

    private void OpenRequest() {
        Intent intent = new Intent(this, Request.class);
        startActivity(intent);
    }
}
