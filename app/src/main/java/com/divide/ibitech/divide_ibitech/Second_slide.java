package com.divide.ibitech.divide_ibitech;



        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.ViewParent;

public class Second_slide extends AppCompatActivity {


    private ViewPager mPager;
    private  int [] layouts = (R.layout.first_slide,R.layout.activity_intro_slider)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_slide);

        mPager =(ViewPager)findViewById(R.id.viewPager);

    }
}