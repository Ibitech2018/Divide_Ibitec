package com.divide.ibitech.divide_ibitech;


import android.content.Context;
import android.widget.Toast;

import com.divide.ibitech.divide_ibitech.mBD.DBAdapter;
import com.divide.ibitech.divide_ibitech.mModel.Device;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * Created by s216100801 on 2018/06/10.
 */

public class TableHelper {

    //DECLARATIONS
    Context c;
    private String[] deciveHeaders = {" Name", "Practitioner", "Date", "Status"};
    private String[][] deviceProbes;

    //CONSTRUCTOR
    public TableHelper(Context c) {
        this.c = c;
    }

    //RETURN TABLE HEADERS
    public String[] getdeciveHeaders() {
        return deciveHeaders;
    }

    //RETURN TABLE ROWS
    public String[][] getdeviceProbes() {
        ArrayList<Device> deviceList = new DBAdapter(c).retrieveDevice();


        deviceProbes= new String[deviceList.size()][4];

        for (int i = 0; i < deviceList.size(); i++) {

            Device   d = deviceList.get(i);

            deviceProbes[i][0] = d.getDeviceName();
            deviceProbes[i][1] = d.getpractitioner_Name();
            deviceProbes[i][2] = d.getdate();
            deviceProbes[i][3] = d.getstatus_Device();

        }

        return deviceProbes;

    }
}