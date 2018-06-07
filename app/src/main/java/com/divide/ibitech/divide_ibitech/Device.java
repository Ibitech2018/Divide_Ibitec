package com.divide.ibitech.divide_ibitech;

/**
 * Created by s216100801 on 2018/06/07.
 */

public class Device {
   /* Instance  fields
    */

    private String device_Name;
    private String practitioner_Name;
    private String date;
    private String status_Device;

    public  String getDeviceName(){
        return device_Name;
    }
    public  void  setDevice_Name(String device_Name){
        this.device_Name=device_Name;
    }

    public  String getpractitioner_Name(){
        return practitioner_Name;
    }
    public  void  setpractitioner_Name(String practitioner_Name){
        this.practitioner_Name=practitioner_Name;
    }

    public  String getdate(){
        return date;
    }
    public  void  setdate(String date){
        this.date=date;
    }

    public  String getstatus_Device(){
        return status_Device;
    }
    public  void  setstatus_Device(String status_Device){
        this.status_Device=status_Device;
    }
    /*
    TO STRING
     */
}
