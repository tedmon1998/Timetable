package com.example.timetable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    String url;
    private TextView textView11_1;
    private TextView textView11_2;
    private TextView textView11_3;
    private TextView textView11_4;
    private TextView textView13_1;
    private TextView textView13_2;
    private TextView textView13_3;
    private TextView textView13_4;
    private TextView textView22_1;
    private TextView textView22_2;
    private TextView textView22_3;
    private TextView textView22_4;
    private TextView textView31_1;
    private TextView textView31_2;
    private TextView textView31_3;
    private TextView textView31_4;
    private TextView textView33_1;
    private TextView textView33_2;
    private TextView textView33_3;
    private TextView textView33_4;
    private TextView data_time;
    private TextView data_data;
    private RequestQueue RQ;
    private RequestQueue DQ;
    private Button button1, button2, button3,
            button4, button5, button6;
    private RequestQueue SS;
    private RequestQueue OTPRAVKA;
    int data_or_int;
    int date_int;
    int or;
    int cn;
    int up;
    //////////////////////////
    TextView textView23_1_1, textView23_1_2, textView23_1_3, textView23_1_4;
    TextView textView23_2_1, textView23_2_2, textView23_2_3, textView23_2_4;
    TextView textView23_3_1, textView23_3_2, textView23_3_3, textView23_3_4;
    TextView textView23_4_1, textView23_4_2, textView23_4_3, textView23_4_4;
    TextView textView21_4, textView21_1, textView32_1, textView21_3, textView21_2, textView32_2, textView32_4;
    ScrollView scrollView2;
    LinearLayout LAYOUT;
    LinearLayout LinearLayout1, LinearLayout2, LinearLayout3, LinearLayout4, linearLayout1;
    LinearLayout podgruppi_1, podgruppi_2, podgruppi_3, podgruppi_4;
    LinearLayout linearLayout2;
    TextView test;
    View poloska1, poloska2, poloska3, poloska4, poloska5;
    TextView textView32_3;
    int update;
    HorizontalScrollView scrol_1, scrol_2, scrol_3, scrol_4;
    ConstraintLayout FON;
    SharedPreferences sPref;
    final String SAVED_TEXT = "";
    Switch switch_settings;
    Button plyus;
    String dateText = "";
    public String nomer = "";
    int nomera_int;
    /////////////////////////////FOR BD///////////////////////////////////////////////
    DBHelper dbHelper;
    /////////////////////////////////////////////////////////////////////////////////

    String host = "http://d06062020.beget.tech/";
    String put = "files/PHPbyAPP/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///////////////////////////////////////////////////////////////////////////////////////
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Display display = getWindowManager().getDefaultDisplay();
            int height = display.getHeight();
            if(height<200){
                setContentView(R.layout.activity_main_200);
            }
            if(height<300){
                setContentView(R.layout.activity_main_300);
            }
            if(height<400){
                setContentView(R.layout.activity_main_400);
            }
            if(height<500){
                setContentView(R.layout.activity_main_500);
            }
            else {
                setContentView(R.layout.activity_main);
            }
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Display display = getWindowManager().getDefaultDisplay();
            int height = display.getHeight();
            if(height<200){
                setContentView(R.layout.activity_main_200_povorot);
            }
            if(height<300){
                setContentView(R.layout.activity_main_300_povorot);
            }
            if(height<400){
                setContentView(R.layout.activity_main_400_povorot);
            }
            if(height<500){
                setContentView(R.layout.activity_main_500_povorot);
            }
            else {
                setContentView(R.layout.activity_main_povorot);
            }
        }

///////////////////////////////////////////////////////////////////////////////////////
        scrol_1 = findViewById(R.id.scrol_1);
        scrol_2 = findViewById(R.id.scrol_2);
        scrol_3 = findViewById(R.id.scrol_3);
        scrol_4 = findViewById(R.id.scrol_4);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_information:
                                Toast toast = Toast.makeText(getApplicationContext(), "ВРЕМЕННО НЕ ДОСТУПЕН, ДАННЫЙ РАЗДЕЛ", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case R.id.action_settings:
                                Intent intent_settings = new Intent(MainActivity.this, Settings.class);
                                startActivity(intent_settings);
                                break;
                        }
                        return false;
                    }
                });

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        poloska1 = findViewById(R.id.poloska1);
        poloska2 = findViewById(R.id.poloska2);
        poloska3 = findViewById(R.id.poloska3);
        poloska4 = findViewById(R.id.poloska4);
        poloska5 = findViewById(R.id.poloska5);
        plyus = findViewById(R.id.plyus);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        data_time = findViewById(R.id.data_time);
        data_data = findViewById(R.id.data_data);
        textView11_1 = findViewById(R.id.textView11_1);
        textView11_2 = findViewById(R.id.textView11_2);
        textView11_3 = findViewById(R.id.textView11_3);
        textView11_4 = findViewById(R.id.textView11_4);
        textView13_1 = findViewById(R.id.textView13_1);
        textView13_2 = findViewById(R.id.textView13_2);
        textView13_3 = findViewById(R.id.textView13_3);
        textView13_4 = findViewById(R.id.textView13_4);
        textView22_1 = findViewById(R.id.textView22_1);
        textView22_2 = findViewById(R.id.textView22_2);
        textView22_3 = findViewById(R.id.textView22_3);
        textView22_4 = findViewById(R.id.textView22_4);
        textView31_1 = findViewById(R.id.textView31_1);
        textView31_2 = findViewById(R.id.textView31_2);
        textView31_3 = findViewById(R.id.textView31_3);
        textView31_4 = findViewById(R.id.textView31_4);
        textView33_1 = findViewById(R.id.textView33_1);
        textView33_2 = findViewById(R.id.textView33_2);
        textView33_3 = findViewById(R.id.textView33_3);
        textView33_4 = findViewById(R.id.textView33_4);
        textView32_3 = findViewById(R.id.textView32_3);
        FON = findViewById(R.id.FON);
        //////////////////////////////////////////////
        textView23_1_1 = findViewById(R.id.textView23_1_1);
        textView23_1_2 = findViewById(R.id.textView23_1_2);
        textView23_1_3 = findViewById(R.id.textView23_1_3);
        textView23_1_4 = findViewById(R.id.textView23_1_4);
        textView23_2_1 = findViewById(R.id.textView23_2_1);
        textView23_2_2 = findViewById(R.id.textView23_2_2);
        textView23_2_3 = findViewById(R.id.textView23_2_3);
        textView23_2_4 = findViewById(R.id.textView23_2_4);
        textView23_3_1 = findViewById(R.id.textView23_3_1);
        textView23_3_2 = findViewById(R.id.textView23_3_2);
        textView23_3_3 = findViewById(R.id.textView23_3_3);
        textView23_3_4 = findViewById(R.id.textView23_3_4);
        textView23_4_1 = findViewById(R.id.textView23_4_1);
        textView23_4_2 = findViewById(R.id.textView23_4_2);
        textView23_4_3 = findViewById(R.id.textView23_4_3);
        textView23_4_4 = findViewById(R.id.textView23_4_4);
        textView21_3 = findViewById(R.id.textView21_3);
        textView21_4 = findViewById(R.id.textView21_4);
        textView21_2 = findViewById(R.id.textView21_2);
        textView32_4 = findViewById(R.id.textView32_4);
        textView32_2 = findViewById(R.id.textView32_2);
        scrollView2 = findViewById(R.id.scrollView2);
        linearLayout1 = findViewById(R.id.linearLayout1);
        LinearLayout1 = findViewById(R.id.LinearLayout1);
        LinearLayout2 = findViewById(R.id.LinearLayout2);
        LinearLayout3 = findViewById(R.id.LinearLayout3);
        LinearLayout4 = findViewById(R.id.LinearLayout4);
        linearLayout2 = findViewById(R.id.LinearLayout4);
        podgruppi_1 = findViewById(R.id.podgruppi_1);
        podgruppi_2 = findViewById(R.id.podgruppi_2);
        podgruppi_3 = findViewById(R.id.podgruppi_3);
        podgruppi_4 = findViewById(R.id.podgruppi_4);
        LAYOUT = findViewById(R.id.LAYOUT);
        textView32_1 = findViewById(R.id.textView32_1);
        textView21_1 = findViewById(R.id.textView21_1);
        test = findViewById(R.id.test);
        //////////////////////////////////////////////
        SS = Volley.newRequestQueue(this);
        DQ = Volley.newRequestQueue(this);
        RQ = Volley.newRequestQueue(this);
        OTPRAVKA = Volley.newRequestQueue(this);
        jsonPares_dni();
        jsonStatus();
        Loader();

        plyus.setText(nomer);
        if(!TextUtils.isEmpty(nomer)) {
            nomera_int = Integer.parseInt(nomer);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "укажите пожалуйста в настройках ваш номер по журналу",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
        switch_settings = findViewById(R.id.switch_inversiya);
        sPref = getSharedPreferences("inversiya", MODE_PRIVATE);
        final boolean inversiya = sPref.getBoolean("", false);

        if (inversiya == true) {


            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Расписание</font>"));

            FON.setBackgroundColor(Color.parseColor("#000000"));

            data_data.setTextColor(Color.parseColor("#ffffff"));
            data_time.setTextColor(Color.parseColor("#ffffff"));
            /////////////////////////////////////////////////////////////////////////////////////
            textView11_1.setTextColor(Color.parseColor("#FFFFFF"));

            textView21_1.setTextColor(Color.parseColor("#FFFFFF"));

            textView22_1.setTextColor(Color.parseColor("#FFFFFF"));

            textView13_1.setTextColor(Color.parseColor("#FFFFFF"));

            textView31_1.setTextColor(Color.parseColor("#FFFFFF"));
            textView32_1.setTextColor(Color.parseColor("#FFFFFF"));
            textView33_1.setTextColor(Color.parseColor("#FFFFFF"));


            /////////////////////////////////////////////////////////////////////////////////////

            textView11_2.setTextColor(Color.parseColor("#FFFFFF"));

            textView21_2.setTextColor(Color.parseColor("#FFFFFF"));

            textView22_2.setTextColor(Color.parseColor("#FFFFFF"));

            textView13_2.setTextColor(Color.parseColor("#FFFFFF"));

            textView31_2.setTextColor(Color.parseColor("#FFFFFF"));
            textView32_2.setTextColor(Color.parseColor("#FFFFFF"));
            textView33_2.setTextColor(Color.parseColor("#FFFFFF"));

            /////////////////////////////////////////////////////////////////////////////////////

            textView11_3.setTextColor(Color.parseColor("#FFFFFF"));

            textView21_3.setTextColor(Color.parseColor("#FFFFFF"));

            textView22_3.setTextColor(Color.parseColor("#FFFFFF"));

            textView13_3.setTextColor(Color.parseColor("#FFFFFF"));

            textView31_3.setTextColor(Color.parseColor("#FFFFFF"));
            textView32_3.setTextColor(Color.parseColor("#FFFFFF"));
            textView33_3.setTextColor(Color.parseColor("#FFFFFF"));



            /////////////////////////////////////////////////////////////////////////////////////

            textView11_4.setTextColor(Color.parseColor("#FFFFFF"));

            textView21_4.setTextColor(Color.parseColor("#FFFFFF"));

            textView22_4.setTextColor(Color.parseColor("#FFFFFF"));

            textView13_4.setTextColor(Color.parseColor("#FFFFFF"));

            textView31_4.setTextColor(Color.parseColor("#FFFFFF"));
            textView32_4.setTextColor(Color.parseColor("#FFFFFF"));
            textView33_4.setTextColor(Color.parseColor("#FFFFFF"));

            linearLayout1.setBackgroundColor(Color.parseColor("#000000"));
            LinearLayout1.setBackgroundResource(R.drawable.fon_layout_inversiya);
            LinearLayout2.setBackgroundResource(R.drawable.fon_layout_inversiya);
            LinearLayout3.setBackgroundResource(R.drawable.fon_layout_inversiya);
            LinearLayout4.setBackgroundResource(R.drawable.fon_layout_inversiya);
            linearLayout2.setBackgroundResource(R.drawable.fon_layout_inversiya);

            poloska1.setBackgroundColor(Color.parseColor("#ffffff"));
            poloska2.setBackgroundColor(Color.parseColor("#ffffff"));
            poloska3.setBackgroundColor(Color.parseColor("#ffffff"));
            poloska4.setBackgroundColor(Color.parseColor("#ffffff"));
            poloska5.setBackgroundColor(Color.parseColor("#ffffff"));

            button1.setBackgroundResource(R.drawable.activ_btn);
            button2.setBackgroundResource(R.drawable.activ_btn);
            button3.setBackgroundResource(R.drawable.activ_btn);
            button4.setBackgroundResource(R.drawable.activ_btn);
            button5.setBackgroundResource(R.drawable.activ_btn);
            button6.setBackgroundResource(R.drawable.activ_btn);
/////////////////////////////////////////////////////////////////////////////////////
        } else {

            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Расписание</font>"));

            data_data.setTextColor(Color.parseColor("#000000"));
            data_time.setTextColor(Color.parseColor("#000000"));

            FON.setBackgroundColor(Color.parseColor("#FFFFFF"));
            FON.setBackgroundColor(Color.parseColor("#FFFFFF"));
            LAYOUT.setBackgroundColor(Color.parseColor("#FFFFFF"));
            /////////////////////////////////////////////////////////////////////////////////////
            textView11_1.setTextColor(Color.parseColor("#000000"));


            textView21_1.setTextColor(Color.parseColor("#000000"));


            textView22_1.setTextColor(Color.parseColor("#000000"));


            textView13_1.setTextColor(Color.parseColor("#000000"));


            textView31_1.setTextColor(Color.parseColor("#000000"));
            textView32_1.setTextColor(Color.parseColor("#000000"));
            textView33_1.setTextColor(Color.parseColor("#000000"));



            /////////////////////////////////////////////////////////////////////////////////////

            textView11_2.setTextColor(Color.parseColor("#000000"));


            textView21_2.setTextColor(Color.parseColor("#000000"));


            textView22_2.setTextColor(Color.parseColor("#000000"));


            textView13_2.setTextColor(Color.parseColor("#000000"));


            textView31_2.setTextColor(Color.parseColor("#000000"));
            textView32_2.setTextColor(Color.parseColor("#000000"));
            textView33_2.setTextColor(Color.parseColor("#000000"));



            /////////////////////////////////////////////////////////////////////////////////////

            textView11_3.setTextColor(Color.parseColor("#000000"));


            textView21_3.setTextColor(Color.parseColor("#000000"));

            textView22_3.setTextColor(Color.parseColor("#000000"));


            textView13_3.setTextColor(Color.parseColor("#000000"));

            textView31_3.setTextColor(Color.parseColor("#000000"));
            textView32_3.setTextColor(Color.parseColor("#000000"));
            textView33_3.setTextColor(Color.parseColor("#000000"));


            /////////////////////////////////////////////////////////////////////////////////////

            textView11_4.setTextColor(Color.parseColor("#000000"));

            textView21_4.setTextColor(Color.parseColor("#000000"));

            textView22_4.setTextColor(Color.parseColor("#000000"));

            textView13_4.setTextColor(Color.parseColor("#000000"));

            textView31_4.setTextColor(Color.parseColor("#000000"));
            textView32_4.setTextColor(Color.parseColor("#000000"));
            textView33_4.setTextColor(Color.parseColor("#000000"));

            button1.setBackgroundResource(R.drawable.btn_deactiv);
            button2.setBackgroundResource(R.drawable.btn_deactiv);
            button3.setBackgroundResource(R.drawable.btn_deactiv);
            button4.setBackgroundResource(R.drawable.btn_deactiv);
            button5.setBackgroundResource(R.drawable.btn_deactiv);
            button6.setBackgroundResource(R.drawable.btn_deactiv);

            linearLayout1.setBackgroundColor(Color.parseColor("#ffffff"));
            LinearLayout1.setBackgroundResource(R.drawable.fon_layout);
            LinearLayout2.setBackgroundResource(R.drawable.fon_layout);
            LinearLayout3.setBackgroundResource(R.drawable.fon_layout);
            LinearLayout4.setBackgroundResource(R.drawable.fon_layout);
            linearLayout2.setBackgroundResource(R.drawable.fon_layout);

            poloska1.setBackgroundColor(Color.parseColor("#000000"));
            poloska2.setBackgroundColor(Color.parseColor("#000000"));
            poloska3.setBackgroundColor(Color.parseColor("#000000"));
            poloska4.setBackgroundColor(Color.parseColor("#000000"));
            poloska5.setBackgroundColor(Color.parseColor("#000000"));
/////////////////////////////////////////////////////////////////////////////////////
            dbHelper = new DBHelper(this);
        }
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button2.setBackgroundResource(R.drawable.activ_btn);
                    button3.setBackgroundResource(R.drawable.activ_btn);
                    button4.setBackgroundResource(R.drawable.activ_btn);
                    button5.setBackgroundResource(R.drawable.activ_btn);
                    button6.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button2.setBackgroundResource(R.drawable.btn_deactiv);
                    button3.setBackgroundResource(R.drawable.btn_deactiv);
                    button4.setBackgroundResource(R.drawable.btn_deactiv);
                    button5.setBackgroundResource(R.drawable.btn_deactiv);
                    button6.setBackgroundResource(R.drawable.btn_deactiv);
                }

                rasp(1);
                jsonPares_dni();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button1.setBackgroundResource(R.drawable.activ_btn);
                    button3.setBackgroundResource(R.drawable.activ_btn);
                    button4.setBackgroundResource(R.drawable.activ_btn);
                    button5.setBackgroundResource(R.drawable.activ_btn);
                    button6.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button1.setBackgroundResource(R.drawable.btn_deactiv);
                    button3.setBackgroundResource(R.drawable.btn_deactiv);
                    button4.setBackgroundResource(R.drawable.btn_deactiv);
                    button5.setBackgroundResource(R.drawable.btn_deactiv);
                    button6.setBackgroundResource(R.drawable.btn_deactiv);
                }
                rasp(2);
                jsonPares_dni();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button1.setBackgroundResource(R.drawable.activ_btn);
                    button2.setBackgroundResource(R.drawable.activ_btn);
                    button4.setBackgroundResource(R.drawable.activ_btn);
                    button5.setBackgroundResource(R.drawable.activ_btn);
                    button6.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button1.setBackgroundResource(R.drawable.btn_deactiv);
                    button2.setBackgroundResource(R.drawable.btn_deactiv);
                    button4.setBackgroundResource(R.drawable.btn_deactiv);
                    button5.setBackgroundResource(R.drawable.btn_deactiv);
                    button6.setBackgroundResource(R.drawable.btn_deactiv);
                }


                rasp(3);
                jsonPares_dni();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button1.setBackgroundResource(R.drawable.activ_btn);
                    button2.setBackgroundResource(R.drawable.activ_btn);
                    button3.setBackgroundResource(R.drawable.activ_btn);
                    button5.setBackgroundResource(R.drawable.activ_btn);
                    button6.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button1.setBackgroundResource(R.drawable.btn_deactiv);
                    button2.setBackgroundResource(R.drawable.btn_deactiv);
                    button3.setBackgroundResource(R.drawable.btn_deactiv);
                    button5.setBackgroundResource(R.drawable.btn_deactiv);
                    button6.setBackgroundResource(R.drawable.btn_deactiv);
                }


                rasp(4);
                jsonPares_dni();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button1.setBackgroundResource(R.drawable.activ_btn);
                    button2.setBackgroundResource(R.drawable.activ_btn);
                    button3.setBackgroundResource(R.drawable.activ_btn);
                    button4.setBackgroundResource(R.drawable.activ_btn);
                    button6.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button1.setBackgroundResource(R.drawable.btn_deactiv);
                    button2.setBackgroundResource(R.drawable.btn_deactiv);
                    button3.setBackgroundResource(R.drawable.btn_deactiv);
                    button4.setBackgroundResource(R.drawable.btn_deactiv);
                    button6.setBackgroundResource(R.drawable.btn_deactiv);
                }


                rasp(5);
                jsonPares_dni();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrol_1.scrollTo(0, 0);
                scrol_2.scrollTo(0, 0);
                scrol_3.scrollTo(0, 0);
                scrol_4.scrollTo(0, 0);
                ///////////////////////////////////////////////////////////////////////////////////////
                if(inversiya == true){
                    view.setBackgroundResource(R.drawable.btn_deactiv);
                    button1.setBackgroundResource(R.drawable.activ_btn);
                    button2.setBackgroundResource(R.drawable.activ_btn);
                    button3.setBackgroundResource(R.drawable.activ_btn);
                    button4.setBackgroundResource(R.drawable.activ_btn);
                    button5.setBackgroundResource(R.drawable.activ_btn);
                }
                if(inversiya == false){
                    view.setBackgroundResource(R.drawable.activ_btn);
                    button1.setBackgroundResource(R.drawable.btn_deactiv);
                    button2.setBackgroundResource(R.drawable.btn_deactiv);
                    button3.setBackgroundResource(R.drawable.btn_deactiv);
                    button4.setBackgroundResource(R.drawable.btn_deactiv);
                    button5.setBackgroundResource(R.drawable.btn_deactiv);
                }

                rasp(6);
                jsonPares_dni();
            }
        });

///////////////////////////////////////////////////////////////////////////////////////
        // Текущее время
        Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        dateText = dateFormat.format(currentDate);
        ///////////////////////////////////////////////////////////////////////////////////////

        plyus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int nomera_studentov = 1 ; nomera_studentov < 31; nomera_studentov++) {
                    if (nomera_int == nomera_studentov) {
                        PLYUS();
                        view.setBackgroundResource(R.drawable.buttonshapetwo);
                        plyus.setText("✓");
                        sPref = getSharedPreferences("status_button", MODE_PRIVATE);
                        SharedPreferences.Editor save_date = sPref.edit();
                        date_int = Integer.parseInt(dateText);
                        save_date.putInt("", date_int);
                        save_date.commit();
                        plyus.setClickable(false);
                    }
                }
            }
        });

        loadDatas();


    }


    ///////////////////////////////////////////////////////////////////////////////////////


    String updateUrl = "https://github.com/tedmon1998/obnova/raw/master/app-debug.apk";

    public void onUpdateNeeded() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Доступна новая версия")
                .setMessage("Пожалуйста, обновите приложение до новой версии, чтобы продолжить работу.")
                .setPositiveButton("Обновить",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                redirectStore(updateUrl);
                            }
                        }).setNegativeButton("Нет, спасибо",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).create();
        dialog.show();
    }

    private void redirectStore(String updateUrl) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public void jsonPares_dni() {

        String dni = host+"files/PHPbyAPP/dni.php";

        JsonObjectRequest request_dni = new JsonObjectRequest(Request.Method.GET, dni, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject request_dni) {
                        try {
                            JSONArray DNI = request_dni.getJSONArray("den");
                            for (int i = 0; i < DNI.length(); i++) {
                                JSONObject parsing_dni = DNI.getJSONObject(i);
                                String dni = parsing_dni.getString("dni");
                                String datas = parsing_dni.getString("datas");
                                data_data.setText(datas);
                                data_time.setText(dni);
                                sPref = getSharedPreferences("datas", MODE_PRIVATE);
                                SharedPreferences.Editor save_datas = sPref.edit();
                                save_datas.putString(SAVED_TEXT, data_data.getText().toString());
                                save_datas.commit();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        DQ.add(request_dni);

    }

    public void Loader(){

        sPref = getSharedPreferences("datas", MODE_PRIVATE);
        String load_datas = sPref.getString(SAVED_TEXT, "");
        data_data.setText(load_datas);

        String data_or = load_datas.substring(6, 8);
        data_or_int = Integer.parseInt(data_or);
///////////////////////////////////////////////////////////////////////////////////////


        sPref = getSharedPreferences("nomer", MODE_PRIVATE);
        nomer = sPref.getString("", "");
    }

    public void loadDatas() {

        sPref = getSharedPreferences("status_button", MODE_PRIVATE);
        int datas = sPref.getInt("", 0);

        if (datas == data_or_int) {
            plyus.setVisibility(View.GONE);
        } else {
            plyus.setClickable(true);
        }


        sPref = getSharedPreferences("or", MODE_PRIVATE);
        or = sPref.getInt("", 0);
///////////////////////////////////////////////////////////////////////////////////////
}

void rasp (int or)
{
    //////////////////////////FOR_BD/////////////////////////////////////////////////////
    SQLiteDatabase database = dbHelper.getWritableDatabase();
    Cursor cursor = database.rawQuery("SELECT * FROM "+DBHelper.TABLE_VSE+" ORDER BY "+DBHelper.KEY_ID+" ASC", null);

///////////////////////////////////////////////////////////////////////////////////////
    switch (or)
    {

        case 1:
            if (cursor.moveToFirst()) {
                cursor.moveToPosition(0);
                            textView11_1.setText(cursor.getString(1));
                cursor.moveToPosition(0);
                            textView13_1.setText(cursor.getString(2));
                cursor.moveToPosition(0);
                            textView22_1.setText(cursor.getString(4));
                cursor.moveToPosition(0);
                            textView31_1.setText(cursor.getString(3));
                cursor.moveToPosition(0);
                            textView33_1.setText(cursor.getString(5));
                cursor.moveToPosition(0);
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(1);
                            textView11_2.setText(cursor.getString(1));
                cursor.moveToPosition(1);
                            textView13_2.setText(cursor.getString(2));
                cursor.moveToPosition(1);
                            textView22_2.setText(cursor.getString(4));
                cursor.moveToPosition(1);
                            textView31_2.setText(cursor.getString(3));
                cursor.moveToPosition(1);
                            textView33_2.setText(cursor.getString(5));
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(2);
                            textView11_3.setText(cursor.getString(1));
                cursor.moveToPosition(2);
                            textView13_3.setText(cursor.getString(2));
                cursor.moveToPosition(2);
                            textView22_3.setText(cursor.getString(4));
                cursor.moveToPosition(2);
                            textView31_3.setText(cursor.getString(3));
                cursor.moveToPosition(2);
                            textView33_3.setText(cursor.getString(5));
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(3);
                            textView11_4.setText(cursor.getString(1));
                cursor.moveToPosition(3);
                            textView13_4.setText(cursor.getString(2));
                cursor.moveToPosition(3);
                            textView22_4.setText(cursor.getString(4));
                cursor.moveToPosition(3);
                            textView31_4.setText(cursor.getString(3));
                cursor.moveToPosition(3);
                            textView33_4.setText(cursor.getString(5));
            } else
            {
                Toast toast = Toast.makeText(getApplicationContext(), "error-null", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
            break;

        case 2:
            if (cursor.moveToFirst()) {
                cursor.moveToPosition(4);
                textView11_1.setText(cursor.getString(1));
                cursor.moveToPosition(4);
                textView13_1.setText(cursor.getString(2));
                cursor.moveToPosition(4);
                textView22_1.setText(cursor.getString(4));
                cursor.moveToPosition(4);
                textView31_1.setText(cursor.getString(3));
                cursor.moveToPosition(4);
                textView33_1.setText(cursor.getString(5));
                cursor.moveToPosition(4);
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(5);
                textView11_2.setText(cursor.getString(1));
                cursor.moveToPosition(5);
                textView13_2.setText(cursor.getString(2));
                cursor.moveToPosition(5);
                textView22_2.setText(cursor.getString(4));
                cursor.moveToPosition(5);
                textView31_2.setText(cursor.getString(3));
                cursor.moveToPosition(5);
                textView33_2.setText(cursor.getString(5));
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(6);
                textView11_3.setText(cursor.getString(1));
                cursor.moveToPosition(6);
                textView13_3.setText(cursor.getString(2));
                cursor.moveToPosition(6);
                textView22_3.setText(cursor.getString(4));
                cursor.moveToPosition(6);
                textView31_3.setText(cursor.getString(3));
                cursor.moveToPosition(6);
                textView33_3.setText(cursor.getString(5));
/////////////////////////////////////////////////////////////////////
                cursor.moveToPosition(7);
                textView11_4.setText(cursor.getString(1));
                cursor.moveToPosition(7);
                textView13_4.setText(cursor.getString(2));
                cursor.moveToPosition(7);
                textView22_4.setText(cursor.getString(4));
                cursor.moveToPosition(7);
                textView31_4.setText(cursor.getString(3));
                cursor.moveToPosition(7);
                textView33_4.setText(cursor.getString(5));
            } else
            {
                Toast toast = Toast.makeText(getApplicationContext(), "error-null", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
            break;

        case 3:
            break;

        case 4:
            break;

        case 5:
            break;

        case 6:
            break;

        case 7:
            break;
    }

}

    ///////////////////////////////////////////////////////////////////////////////////////




    public void ramca_0() {
        textView23_1_1.setBackgroundResource(R.drawable.red_frame_0);
        textView23_1_2.setBackgroundResource(R.drawable.red_frame_0);
        textView23_1_3.setBackgroundResource(R.drawable.red_frame_0);
        textView23_1_4.setBackgroundResource(R.drawable.red_frame_0);
        textView23_2_1.setBackgroundResource(R.drawable.red_frame_0);
        textView23_2_2.setBackgroundResource(R.drawable.red_frame_0);
        textView23_2_3.setBackgroundResource(R.drawable.red_frame_0);
        textView23_2_4.setBackgroundResource(R.drawable.red_frame_0);
        textView23_3_1.setBackgroundResource(R.drawable.red_frame_0);
        textView23_3_2.setBackgroundResource(R.drawable.red_frame_0);
        textView23_3_3.setBackgroundResource(R.drawable.red_frame_0);
        textView23_3_4.setBackgroundResource(R.drawable.red_frame_0);
        textView23_4_1.setBackgroundResource(R.drawable.red_frame_0);
        textView23_4_2.setBackgroundResource(R.drawable.red_frame_0);
        textView23_4_3.setBackgroundResource(R.drawable.red_frame_0);
        textView23_4_4.setBackgroundResource(R.drawable.red_frame_0);
        up = 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    String sta = host+"files/PHPbyAPP/status.php";

    public void jsonStatus() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, sta, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray ST = response.getJSONArray("status");
                            for (int i = 0; i < ST.length(); i++) {
                                JSONObject parsing = ST.getJSONObject(i);
                                cn = parsing.getInt("cn");
                                update = parsing.getInt("update");
                                ///////////////////////////////////////////////////////////////////////////////////////
                                int versiya = 12;

                                if (update != versiya) {
                                    onUpdateNeeded();
                                }
                                ///////////////////////////////////////////////////////////////////////////////////////
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        SS.add(request);
    }
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////


    public void PLYUS() {
        url = host+"files/PHPbyAPP/plyus.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", String.valueOf(test));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("message", nomer);
                return params;
            }
        };
        OTPRAVKA.add(postRequest);
    }


}