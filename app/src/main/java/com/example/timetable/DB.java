package com.example.timetable;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DB extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        switch (v.getId()) {

            case R.id.btnAdd:

                Intent intent = new Intent(DB.this, SplashActivity.class);
                startActivity(intent);

                break;

            case R.id.btnRead:
                Cursor cursor_0 = database.query(DBHelper.TABLE_VSE, null, null, null, null, null, null);


                Cursor cursor = database.rawQuery("SELECT * FROM "+DBHelper.TABLE_VSE+" ORDER BY "+DBHelper.KEY_ID+" ASC", null);
                if(cursor.moveToFirst())
                {
                        cursor.moveToPosition(0);
                        while (cursor.moveToNext()) {
                            etName.append(cursor.getString(3));
                        }
                }
                cursor_0.close();

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_VSE, null, null);
                break;
        }
        dbHelper.close();
    }


}