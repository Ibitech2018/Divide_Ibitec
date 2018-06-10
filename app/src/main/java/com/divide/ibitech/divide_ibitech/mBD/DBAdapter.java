package com.divide.ibitech.divide_ibitech.mBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Space;


import com.divide.ibitech.divide_ibitech.mModel.Device;

import java.util.ArrayList;
/**
 * Created by s216100801 on 2018/06/10.
 */

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    /*
    1. INITIALIZE DB HELPER AND PASS IT A CONTEXT

     */
    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }

    /*
   SAVE DATA TO DB
    */
    public boolean saveDevice(Device device) {
        try {
            db = helper.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put(Constants.DEVICENAME, device.getDeviceName());
            cv.put(Constants.PRACTITIONER_NAME, device.getpractitioner_Name());
            cv.put(Constants.DATE, device.getdate());
            cv.put(Constants.STATUS, device.getstatus_Device());


            long result = db.insert(Constants.TB_NAME, Constants.ROW_ID, cv);
            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.close();
        }

        return false;
    }

    /*
     1. RETRIEVE DEVICES FROM DB AND POPULATE ARRAYLIST
     2. RETURN THE LIST
     */

    public ArrayList<Device> retrieveDevice()
    {
        ArrayList<Device> devices=new ArrayList<>();

        String[] columns={Constants.ROW_ID,Constants.DEVICENAME,Constants.PRACTITIONER_NAME,Constants.DATE,Constants.STATUS};

        try
        {
            db = helper.getWritableDatabase();
            Cursor c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);

            Device d;

            if(c != null)
            {
                while (c.moveToNext())
                {
                    String s_devicename=c.getString(1);
                    String sprac_name=c.getString(2);
                    String s_date=c.getString(3);
                    String s_status=c.getString(4);


                    d=new Device();
                    d.setDevice_Name(s_devicename);
                    d.setpractitioner_Name(sprac_name);
                    d.setdate(s_date);
                    d.setstatus_Device(s_status);

                    devices.add(d);
                }
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }


        return devices;
    }

}
