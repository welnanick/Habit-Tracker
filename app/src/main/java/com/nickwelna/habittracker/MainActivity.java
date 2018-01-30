package com.nickwelna.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nickwelna.habittracker.data.HabitContract.HabitEntry;
import com.nickwelna.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    HabitDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public long trackHabit(String name, int type, String date) {

        SQLiteDatabase habits = dbHelper.getWritableDatabase();

        ContentValues pet = new ContentValues();
        pet.put(HabitEntry.COLUMN_HABIT_NAME, name);
        pet.put(HabitEntry.COLUMN_HABIT_TYPE, type);
        pet.put(HabitEntry.COLUMN_HABIT_DATE, date);

        return habits.insert(HabitEntry.TABLE_NAME, null, pet);

    }

    private Cursor getHabitsWithType() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {

                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_TYPE,

        };

        String sortOrder =
                HabitEntry.COLUMN_HABIT_TYPE + " ASC";


        return db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, sortOrder);

    }

}
