package com.divide.ibitech.divide_ibitech;

import android.graphics.drawable.RippleDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.bluetooth.BluetoothClass;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import android.widget.TextView;

public class Requestview extends AppCompatActivity {
private String Name ,deviceName,parctitionerName,dateRequest;
TextView  Date;
    private String[] deciveHeaders = {" Name", "Practitioner", "Date", "Status"};
    private String[][] deviceProbes;
    private String status="Requested";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestview);

        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(4);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));

        //POPULATE
        populateData();

        //ADAPTERS
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, deciveHeaders));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, deviceProbes));

        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(Requestview.this, ((String[]) clickedData)[1], Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void  populateData(){

        Device device = new Device();
        ArrayList<Device> deviceList=new ArrayList<>();

        device.setDevice_Name("Labiti");
        device.setpractitioner_Name("Dr.AJ Gupta");
        device.setdate("88");
        device.setstatus_Device("Labiti");
        deviceList.add(device);

        device=new Device();
        device.setDevice_Name("2");
        device.setpractitioner_Name("Casini");
        device.setdate("25");
        device.setstatus_Device("Jupiter");
        deviceList.add(device);

        device=new Device();
        device.setDevice_Name("2");
        device.setpractitioner_Name("Casini");
        device.setdate("25");
        device.setstatus_Device("Jupiter");
        deviceList.add(device);

        device=new Device();
        device.setDevice_Name("2");
        device.setpractitioner_Name("Casini");
        device.setdate("25");
        device.setstatus_Device("Jupiter");
        deviceList.add(device);

        deviceProbes= new String[deviceList.size()][4];

        for (int i=0;i<deviceList.size();i++) {

            Device d=deviceList.get(i);

            deviceProbes[i][0]=d.getDeviceName();
            deviceProbes[i][1]=d.getpractitioner_Name();
            deviceProbes[i][2]=d.getdate();
            deviceProbes[i][3]=d.getstatus_Device();

        }
    }

}
