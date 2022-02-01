package com.example.timetable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Settings extends AppCompatActivity {
    Switch switch_settings;
    SharedPreferences sPref;
    ConstraintLayout FON;
    View poloska_1;
    View poloska_2;
    EditText nomer_plyus;
    TextView Text_info_plyus;
    TextView textview_inversiya;
    TextView textview_opisaniye_settings;
    String SAVE_NUM = "";
    Button but_plyus;


    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /////////////////////////////////////////////////////////////////////////////////////
        setContentView(R.layout.settings);

        /////////////////////////////////////////////////////////////////////////////////////
        switch_settings = findViewById(R.id.switch_inversiya);
        ///////////////////////////////////////////////////
        sPref = getSharedPreferences("inversiya", MODE_PRIVATE);
        boolean inversiya = sPref.getBoolean("", false);

        switch_settings.setChecked(inversiya);
        poloska_1 = findViewById(R.id.poloska_1);
        poloska_2 = findViewById(R.id.poloska_2);

        nomer_plyus = findViewById(R.id.nomer_plyus);
        Text_info_plyus = findViewById(R.id.Text_info_plyus);
        but_plyus = findViewById(R.id.but_plyus);

        textview_inversiya =  findViewById(R.id.textview_inversiya);
        textview_opisaniye_settings =  findViewById(R.id.textview_opisaniye_settings);
        FON =  findViewById(R.id.FON);

        /////////////////////////////////////////////////////////////////////////////////////
        switch_settings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean chekere) {
                sPref = getSharedPreferences("inversiya", MODE_PRIVATE);
                sPref.edit().putBoolean("", switch_settings.isChecked()).apply();
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /////////////////////////////////////////////////////////////////////////////////////
        switch_settings = findViewById(R.id.switch_inversiya);
        sPref = getSharedPreferences("inversiya", MODE_PRIVATE);
        boolean inversiyaa = sPref.getBoolean("", false);
        if (inversiyaa==true){
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Настройки</font>"));
            switch_settings.setChecked(true);
            FON.setBackgroundColor(Color.parseColor("#000000"));
            textview_inversiya.setTextColor(Color.parseColor("#ffffff"));
            textview_opisaniye_settings.setTextColor(Color.parseColor("#ffffff"));
            poloska_1.setBackgroundColor(Color.parseColor("#ffffff"));
            poloska_2.setBackgroundColor(Color.parseColor("#ffffff"));
            nomer_plyus.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            nomer_plyus.setHintTextColor(Color.WHITE);
            nomer_plyus.setTextColor(Color.parseColor("#ffffff"));
            Text_info_plyus.setHintTextColor(Color.WHITE);
            Text_info_plyus.setTextColor(Color.parseColor("#ffffff"));
        }
        else {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Настройки</font>"));
            switch_settings.setChecked(false);
            FON.setBackgroundColor(Color.parseColor("#ffffff"));
            textview_inversiya.setTextColor(Color.parseColor("#000000"));
            textview_opisaniye_settings.setTextColor(Color.parseColor("#000000"));
            poloska_1.setBackgroundColor(Color.parseColor("#000000"));
            poloska_2.setBackgroundColor(Color.parseColor("#000000"));
            nomer_plyus.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            nomer_plyus.setHintTextColor(Color.BLACK);
            nomer_plyus.setTextColor(Color.parseColor("#000000"));
            Text_info_plyus.setHintTextColor(Color.BLACK);
            Text_info_plyus.setTextColor(Color.parseColor("#000000"));
        }

        nomer_plyus.setHint("№");

////////////////////////////////////////////////////////////

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_information:
                                Toast toast = Toast.makeText(getApplicationContext(), "ВРЕМЕННО НЕ ДОСТУПЕН, ДАННЫЙ РАЗДЕЛ",
                                        Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case R.id.action_home:
                                Intent intent_home = new Intent(Settings.this, MainActivity.class);
                                startActivity(intent_home);
                                break;
                        }
                        return false;
                    }
                });

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        ////////////////////////////////////////////////////////////

        but_plyus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    sPref = getSharedPreferences("nomer", MODE_PRIVATE);
                    SharedPreferences.Editor save_nomer = sPref.edit();
                    save_nomer.putString("", nomer_plyus.getText().toString());
                    save_nomer.commit();
                    view.setBackgroundResource(R.drawable.style_settings_plyus_activ);

                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    view.setBackgroundResource(R.drawable.style_settings_plyus);
                    Toast toast = Toast.makeText(getApplicationContext(), "операция прошла успешно",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                return false;
            }

        });

        Loader();

    }
    public void Loader(){
        sPref = getSharedPreferences("nomer", MODE_PRIVATE);
        String nomer = sPref.getString("", "");
        nomer_plyus.setText(nomer);
    }

}
