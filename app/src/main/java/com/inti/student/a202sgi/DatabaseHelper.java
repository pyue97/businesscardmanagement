package com.inti.student.a202sgi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inti.student.a202sgi.BusinessCard.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BusinessCard.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BusinessCardEntry.TABLE_NAME + " (" +
                BusinessCardEntry.COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BusinessCardEntry.COL_2 + " TEXT, " +
                BusinessCardEntry.COL_3 + " TEXT, " +
                BusinessCardEntry.COL_4 + " TEXT, " +
                BusinessCardEntry.COL_5 + " TEXT, " +
                BusinessCardEntry.COL_6 + " TEXT, " +
                BusinessCardEntry.COL_7 + " TEXT, " +
                BusinessCardEntry.COL_8 + " TEXT, " +
                BusinessCardEntry.COL_9 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BusinessCardEntry.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fName, String lName, String contactNo, String email, String jobTitle, String compName, String compAdd, String compURL) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BusinessCardEntry.COL_2, fName);
        contentValues.put(BusinessCardEntry.COL_3, lName);
        contentValues.put(BusinessCardEntry.COL_4, contactNo);
        contentValues.put(BusinessCardEntry.COL_5, email);
        contentValues.put(BusinessCardEntry.COL_6, jobTitle);
        contentValues.put(BusinessCardEntry.COL_7, compName);
        contentValues.put(BusinessCardEntry.COL_8, compAdd);
        contentValues.put(BusinessCardEntry.COL_9, compURL);
        long result = db.insert(BusinessCardEntry.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }
}
