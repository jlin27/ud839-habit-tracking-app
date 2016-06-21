package com.jessica.trackingapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context. We use this because we are in the activity class
        HabitDbHelper dbHelper = new HabitDbHelper(this);

        // Gets the data repository in write mode
        mDatabase = dbHelper.getWritableDatabase();
    }

    /** Add some text about how insertHabit works**/
    private void insertHabit(){

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, "Studying Italian");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_DATE, "6/17/2016");
        values.put(HabitContract.HabitEntry.COLUMN_DONE, "yes");


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = mDatabase.insert(
                HabitContract.HabitEntry.TABLE_NAME,
                null,
                values);
    }

    private Cursor readHabit(){

        //Gets the data repository in read mode
        HabitDbHelper dbHelper = new HabitDbHelper(this);
        mDatabase = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database we want to read from
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_DATE,
                HabitContract.HabitEntry.COLUMN_DONE
        };

        Cursor cursor = mDatabase.query(
                HabitContract.HabitEntry.TABLE_NAME,// The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // having
                null,                                     // orderBy
                null);                                    // limit


        return cursor;
    }

    private void deleteAll(){

        // Issue SQL statement. whereClause and whereArgs set to null in order to delete all rows
        mDatabase.delete(HabitContract.HabitEntry.TABLE_NAME, null, null);

    }



}
