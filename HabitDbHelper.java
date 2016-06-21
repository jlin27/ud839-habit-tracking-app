package com.jessica.trackingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jessicalin on 6/21/16.
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "habits.db";

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    final private Context mContext;

    public HabitDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // SQL Statement to Create the Pets Table
        final String SQL_CREATE_PETS_TABLE =

                "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" + HabitContract.HabitEntry._ID
                        + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                        + HabitContract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                        + HabitContract.HabitEntry.COLUMN_HABIT_DATE + " TEXT, "
                        + HabitContract.HabitEntry.COLUMN_HABIT_FREQUENCY + " TEXT, "
                        + HabitContract.HabitEntry.COLUMN_DONE + " TEXT )"
                ;

        db.execSQL(SQL_CREATE_PETS_TABLE);
        Log.v(HabitDbHelper.class.getName(),"table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME);
        onCreate(db);
    }

    void deleteDatabase() {
        mContext.deleteDatabase(DATABASE_NAME);
    }
}


