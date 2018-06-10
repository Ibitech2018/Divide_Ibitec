package com.divide.ibitech.divide_ibitech;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import android.widget.TextView;import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.divide.ibitech.divide_ibitech.mBD.DBAdapter;
import com.divide.ibitech.divide_ibitech.mModel.Device;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class Requestview extends AppCompatActivity {
    private String stasus, Name, deviceName, parctitionName, dateRequest;
    TextView Date;

    EditText nameEditText, parctitionerName;
    Button saveBtn;
    TableView<String[]> tb;
    TableHelper tableHelper;

    private String status = "Requested";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TABLEVIEW
        tableHelper = new TableHelper(this);
        tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(3);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelper.getdeciveHeaders()));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, tableHelper.getdeviceProbes()));
        //TABLE CLICK
        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                Toast.makeText(Requestview.this, ((String[]) clickedData)[1], Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });
    }

    /*
DISPLAY INPUT DIALOG
SAVE
*/
    private void displayDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("UPDATE  STATUS");
        dialog.setContentView(R.layout.dialog_layout);

        //INITIALIZE VIEWS
        nameEditText = (EditText) dialog.findViewById(R.id.nameEditTxt);
        parctitionerName = (EditText) dialog.findViewById(R.id.parctitionerName);
        saveBtn = (Button) dialog.findViewById(R.id.saveBtn);

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Device d = new Device();
                d.setDevice_Name(nameEditText.getText().toString());
                d.setpractitioner_Name(parctitionerName.getText().toString());
                d.setdate(dateRequest.toString());
                d.setstatus_Device(stasus.toString());


                if (new DBAdapter(Requestview.this).saveDevice(d)) {
                    nameEditText.setText("");
                    parctitionerName.setText("");
                    dateRequest = "";
                    stasus = "";

                    tb.setDataAdapter(new SimpleTableDataAdapter(Requestview.this, tableHelper.getdeviceProbes()));

                } else {
                    Toast.makeText(Requestview.this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
//SHOW DIALOG
        dialog.show();
    }
}