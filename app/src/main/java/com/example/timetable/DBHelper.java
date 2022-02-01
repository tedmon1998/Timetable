package com.example.timetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bazaDb"; // ODINAKOBIYE!!!
    public static final String TABLE_VSE = "baza"; // ODINAKOBIYE!!!

    public static final String KEY_ID = "_id";
    public static final String N_K = "n_k";
    public static final String K_N = "k_n";
    public static final String N_P = "n_p";
    public static final String AUD = "aud";
    public static final String PREPOD = "prepod";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_VSE + "(" + KEY_ID
                + " integer primary key," + N_K + " text," + K_N + " text," + N_P + " text," + AUD + " text,"
                + PREPOD + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_VSE);


        onCreate(db);

    }

}
