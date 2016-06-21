package com.jessica.trackingapp;

import android.provider.BaseColumns;

/**
 * Created by jessicalin on 6/21/16.
 */
public class HabitContract {

    public static final class HabitEntry implements BaseColumns {

    // Add constants to define table and columns
    public final static String TABLE_NAME = "tracking";

    public final static String _ID = BaseColumns._ID;
    public final static String COLUMN_HABIT_NAME ="name";
    public final static String COLUMN_HABIT_DATE = "date";
    public final static String COLUMN_HABIT_FREQUENCY = "frequency";
    public final static String COLUMN_DONE = "done";


    }
}
