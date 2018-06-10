package com.divide.ibitech.divide_ibitech.mBD;

/**
 * Created by s216100801 on 2018/06/10.
 */

public class Constants {

    /*
COLUMNS
 */
    static final String ROW_ID="id";
    static final String DEVICENAME="name";
    static final String PRACTITIONER_NAME="prac_name";
    static final String DATE="date";
    static final String STATUS="status";


    /*
   DB PROPERTIES
    */
    static final String DB_NAME="tv_DB";
    static final String TB_NAME="tv_TB";
    static final int DB_VERSION=1;

    /*
   TABLE CREATION STATEMENT
    */
    static final String CREATE_TB="CREATE TABLE tv_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,prac_name TEXT NOT NULL,date TEXT NOT NULL,status TEXT NOT NULL);";


    /*
    TABLE DELETION STMT
     */
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
