package com.example.s216100801.drawerlayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NativeActivity;
import android.net.Network;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle nToggle;
private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        nToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Open,R.string.Close);
        mDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
    }
    public void selectItemDrawer(MenuItem menuItem){
        android.support.v4.app.Fragment myFragment= null;
        Class fragmentClass = null;

        switch (menuItem.getItemId()){
            case R.id.profile:
                fragmentClass = MyProfile.class;
                break;
        }
        try {
            myFragment = (android.support.v4.app.Fragment)fragmentClass.newInstance();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,myFragment).commit();
        menuItem.setChecked(true);
    setTitle(menuItem.getTitle());
    mDrawerLayout.closeDrawers();

    }
    private  void   setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }


}
