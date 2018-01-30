package com.nickwelna.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nickwelna.habittracker.data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "habits.db";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitEntry.TABLE_NAME +
            " (" + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HabitEntry.COLUMN_HABIT_NAME + " TEXT, " +
            HabitEntry.COLUMN_HABIT_TYPE + " INTEGER, " + HabitEntry.COLUMN_HABIT_DATE + " TEXT);";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + HabitEntry.TABLE_NAME;

    public HabitDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

}
