package com.example.timetable;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashActivity extends AppCompatActivity {
    DBHelper dbHelper;
    private RequestQueue RQ;

    String host = "http://d06062020.beget.tech/";
    String put = "files/PHPbyAPP/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        dbHelper = new DBHelper(this);
        RQ = Volley.newRequestQueue(this);


        SQLiteDatabase database = dbHelper.getWritableDatabase();


        database.delete(DBHelper.TABLE_VSE, null, null);

        ///////////////////////////////////////////////////////////////////////////
        jsonPares_vse();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run () {
                Intent intent = new Intent(SplashActivity.this, DB.class);
                startActivity(intent);
                finish();
            }
        }, 3*300);
    }

    public void jsonPares_vse() {
        String URLs = host + put + "raspisaniye_vse.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URLs, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            SQLiteDatabase database = dbHelper.getWritableDatabase();
                            ContentValues contentValues = new ContentValues();

                            JSONArray JS = response.getJSONArray("zagalovok");

                            JSONObject parsings_1 = JS.getJSONObject(0);
                            String n_k_1 = parsings_1.getString("n_k");
                            String k_n_1 = parsings_1.getString("k_n");
                            String n_p_1 = parsings_1.getString("n_p");
                            String aud_1 = parsings_1.getString("aud");
                            String prepod_1 = parsings_1.getString("prepod");

                            JSONObject parsings_2 = JS.getJSONObject(1);
                            String n_k_2 = parsings_2.getString("n_k");
                            String k_n_2 = parsings_2.getString("k_n");
                            String n_p_2 = parsings_2.getString("n_p");
                            String aud_2 = parsings_2.getString("aud");
                            String prepod_2 = parsings_2.getString("prepod");

                            JSONObject parsing_3 = JS.getJSONObject(2);
                            String n_k_3 = parsing_3.getString("n_k");
                            String k_n_3 = parsing_3.getString("k_n");
                            String n_p_3 = parsing_3.getString("n_p");
                            String aud_3 = parsing_3.getString("aud");
                            String prepod_3 = parsing_3.getString("prepod");

                            JSONObject parsing_4 = JS.getJSONObject(3);
                            String n_k_4 = parsing_4.getString("n_k");
                            String k_n_4 = parsing_4.getString("k_n");
                            String n_p_4 = parsing_4.getString("n_p");
                            String aud_4 = parsing_4.getString("aud");
                            String prepod_4 = parsing_4.getString("prepod");

                            JSONObject parsings_5 = JS.getJSONObject(0);
                            String n_k_5 = parsings_5.getString("n_k");
                            String k_n_5 = parsings_5.getString("k_n");
                            String n_p_5 = parsings_5.getString("n_p");
                            String aud_5 = parsings_5.getString("aud");
                            String prepod_5 = parsings_5.getString("prepod");

                            JSONObject parsings_6 = JS.getJSONObject(1);
                            String n_k_6 = parsings_6.getString("n_k");
                            String k_n_6 = parsings_6.getString("k_n");
                            String n_p_6 = parsings_6.getString("n_p");
                            String aud_6 = parsings_6.getString("aud");
                            String prepod_6 = parsings_6.getString("prepod");

                            JSONObject parsing_7 = JS.getJSONObject(2);
                            String n_k_7 = parsing_7.getString("n_k");
                            String k_n_7 = parsing_7.getString("k_n");
                            String n_p_7 = parsing_7.getString("n_p");
                            String aud_7 = parsing_7.getString("aud");
                            String prepod_7 = parsing_7.getString("prepod");

                            JSONObject parsing_8 = JS.getJSONObject(3);
                            String n_k_8 = parsing_8.getString("n_k");
                            String k_n_8 = parsing_8.getString("k_n");
                            String n_p_8 = parsing_8.getString("n_p");
                            String aud_8 = parsing_8.getString("aud");
                            String prepod_8 = parsing_8.getString("prepod");

                            JSONObject parsings_9 = JS.getJSONObject(0);
                            String n_k_9 = parsings_9.getString("n_k");
                            String k_n_9 = parsings_9.getString("k_n");
                            String n_p_9 = parsings_9.getString("n_p");
                            String aud_9 = parsings_9.getString("aud");
                            String prepod_9 = parsings_9.getString("prepod");

                            JSONObject parsings_10 = JS.getJSONObject(1);
                            String n_k_10 = parsings_10.getString("n_k");
                            String k_n_10 = parsings_10.getString("k_n");
                            String n_p_10 = parsings_10.getString("n_p");
                            String aud_10 = parsings_10.getString("aud");
                            String prepod_10 = parsings_10.getString("prepod");

                            JSONObject parsing_11 = JS.getJSONObject(2);
                            String n_k_11 = parsing_11.getString("n_k");
                            String k_n_11 = parsing_11.getString("k_n");
                            String n_p_11 = parsing_11.getString("n_p");
                            String aud_11 = parsing_11.getString("aud");
                            String prepod_11 = parsing_11.getString("prepod");

                            JSONObject parsing_12 = JS.getJSONObject(3);
                            String n_k_12 = parsing_12.getString("n_k");
                            String k_n_12 = parsing_12.getString("k_n");
                            String n_p_12 = parsing_12.getString("n_p");
                            String aud_12 = parsing_12.getString("aud");
                            String prepod_12 = parsing_12.getString("prepod");

                            JSONObject parsings_13 = JS.getJSONObject(0);
                            String n_k_13 = parsings_13.getString("n_k");
                            String k_n_13 = parsings_13.getString("k_n");
                            String n_p_13 = parsings_13.getString("n_p");
                            String aud_13 = parsings_13.getString("aud");
                            String prepod_13 = parsings_13.getString("prepod");

                            JSONObject parsings_14 = JS.getJSONObject(1);
                            String n_k_14 = parsings_14.getString("n_k");
                            String k_n_14 = parsings_14.getString("k_n");
                            String n_p_14 = parsings_14.getString("n_p");
                            String aud_14 = parsings_14.getString("aud");
                            String prepod_14 = parsings_14.getString("prepod");

                            JSONObject parsing_15 = JS.getJSONObject(2);
                            String n_k_15 = parsing_15.getString("n_k");
                            String k_n_15 = parsing_15.getString("k_n");
                            String n_p_15 = parsing_15.getString("n_p");
                            String aud_15 = parsing_15.getString("aud");
                            String prepod_15 = parsing_15.getString("prepod");

                            JSONObject parsing_16 = JS.getJSONObject(3);
                            String n_k_16 = parsing_16.getString("n_k");
                            String k_n_16 = parsing_16.getString("k_n");
                            String n_p_16 = parsing_16.getString("n_p");
                            String aud_16 = parsing_16.getString("aud");
                            String prepod_16 = parsing_16.getString("prepod");

                            JSONObject parsings_17 = JS.getJSONObject(0);
                            String n_k_17 = parsings_17.getString("n_k");
                            String k_n_17 = parsings_17.getString("k_n");
                            String n_p_17 = parsings_17.getString("n_p");
                            String aud_17 = parsings_17.getString("aud");
                            String prepod_17 = parsings_17.getString("prepod");

                            JSONObject parsings_18 = JS.getJSONObject(1);
                            String n_k_18 = parsings_18.getString("n_k");
                            String k_n_18 = parsings_18.getString("k_n");
                            String n_p_18 = parsings_18.getString("n_p");
                            String aud_18 = parsings_18.getString("aud");
                            String prepod_18 = parsings_18.getString("prepod");

                            JSONObject parsing_19 = JS.getJSONObject(2);
                            String n_k_19 = parsing_19.getString("n_k");
                            String k_n_19 = parsing_19.getString("k_n");
                            String n_p_19 = parsing_19.getString("n_p");
                            String aud_19 = parsing_19.getString("aud");
                            String prepod_19 = parsing_19.getString("prepod");

                            JSONObject parsing_20 = JS.getJSONObject(3);
                            String n_k_20 = parsing_20.getString("n_k");
                            String k_n_20 = parsing_20.getString("k_n");
                            String n_p_20 = parsing_20.getString("n_p");
                            String aud_20 = parsing_20.getString("aud");
                            String prepod_20 = parsing_20.getString("prepod");

                            JSONObject parsings_21 = JS.getJSONObject(0);
                            String n_k_21 = parsings_21.getString("n_k");
                            String k_n_21 = parsings_21.getString("k_n");
                            String n_p_21 = parsings_21.getString("n_p");
                            String aud_21 = parsings_21.getString("aud");
                            String prepod_21 = parsings_21.getString("prepod");

                            JSONObject parsings_22 = JS.getJSONObject(1);
                            String n_k_22 = parsings_22.getString("n_k");
                            String k_n_22 = parsings_22.getString("k_n");
                            String n_p_22 = parsings_22.getString("n_p");
                            String aud_22 = parsings_22.getString("aud");
                            String prepod_22 = parsings_22.getString("prepod");

                            JSONObject parsing_23 = JS.getJSONObject(2);
                            String n_k_23 = parsing_23.getString("n_k");
                            String k_n_23 = parsing_23.getString("k_n");
                            String n_p_23 = parsing_23.getString("n_p");
                            String aud_23 = parsing_23.getString("aud");
                            String prepod_23 = parsing_23.getString("prepod");

                            JSONObject parsing_24 = JS.getJSONObject(3);
                            String n_k_24 = parsing_24.getString("n_k");
                            String k_n_24 = parsing_24.getString("k_n");
                            String n_p_24 = parsing_24.getString("n_p");
                            String aud_24 = parsing_24.getString("aud");
                            String prepod_24 = parsing_24.getString("prepod");

                            JSONObject parsings_25 = JS.getJSONObject(0);
                            String n_k_25 = parsings_25.getString("n_k");
                            String k_n_25 = parsings_25.getString("k_n");
                            String n_p_25 = parsings_25.getString("n_p");
                            String aud_25 = parsings_25.getString("aud");
                            String prepod_25 = parsings_25.getString("prepod");

                            JSONObject parsing_26 = JS.getJSONObject(1);
                            String n_k_26 = parsing_26.getString("n_k");
                            String k_n_26 = parsing_26.getString("k_n");
                            String n_p_26 = parsing_26.getString("n_p");
                            String aud_26 = parsing_26.getString("aud");
                            String prepod_26 = parsing_26.getString("prepod");

                            JSONObject parsing_27 = JS.getJSONObject(2);
                            String n_k_27 = parsing_27.getString("n_k");
                            String k_n_27 = parsing_27.getString("k_n");
                            String n_p_27 = parsing_27.getString("n_p");
                            String aud_27 = parsing_27.getString("aud");
                            String prepod_27 = parsing_27.getString("prepod");

                            JSONObject parsings_28 = JS.getJSONObject(3);
                            String n_k_28 = parsings_28.getString("n_k");
                            String k_n_28 = parsings_28.getString("k_n");
                            String n_p_28 = parsings_28.getString("n_p");
                            String aud_28 = parsings_28.getString("aud");
                            String prepod_28 = parsings_28.getString("prepod");

                            //////////////////////////////////PON//////////////////////////////////////////
                            contentValues.put(DBHelper.N_K, n_k_1);
                            contentValues.put(DBHelper.K_N, k_n_1);
                            contentValues.put(DBHelper.N_P, n_p_1);
                            contentValues.put(DBHelper.AUD, aud_1);
                            contentValues.put(DBHelper.PREPOD, prepod_1);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_2);
                            contentValues.put(DBHelper.K_N, k_n_2);
                            contentValues.put(DBHelper.N_P, n_p_2);
                            contentValues.put(DBHelper.AUD, aud_2);
                            contentValues.put(DBHelper.PREPOD, prepod_2);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_3);
                            contentValues.put(DBHelper.K_N, k_n_3);
                            contentValues.put(DBHelper.N_P, n_p_3);
                            contentValues.put(DBHelper.AUD, aud_3);
                            contentValues.put(DBHelper.PREPOD, prepod_3);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_4);
                            contentValues.put(DBHelper.K_N, k_n_4);
                            contentValues.put(DBHelper.N_P, n_p_4);
                            contentValues.put(DBHelper.AUD, aud_4);
                            contentValues.put(DBHelper.PREPOD, prepod_4);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////VTOR//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_5);
                            contentValues.put(DBHelper.K_N, k_n_5);
                            contentValues.put(DBHelper.N_P, n_p_5);
                            contentValues.put(DBHelper.AUD, aud_5);
                            contentValues.put(DBHelper.PREPOD, prepod_5);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_6);
                            contentValues.put(DBHelper.K_N, k_n_6);
                            contentValues.put(DBHelper.N_P, n_p_6);
                            contentValues.put(DBHelper.AUD, aud_6);
                            contentValues.put(DBHelper.PREPOD, prepod_6);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_7);
                            contentValues.put(DBHelper.K_N, k_n_7);
                            contentValues.put(DBHelper.N_P, n_p_7);
                            contentValues.put(DBHelper.AUD, aud_7);
                            contentValues.put(DBHelper.PREPOD, prepod_7);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_8);
                            contentValues.put(DBHelper.K_N, k_n_8);
                            contentValues.put(DBHelper.N_P, n_p_8);
                            contentValues.put(DBHelper.AUD, aud_8);
                            contentValues.put(DBHelper.PREPOD, prepod_8);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////SRED//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_9);
                            contentValues.put(DBHelper.K_N, k_n_9);
                            contentValues.put(DBHelper.N_P, n_p_9);
                            contentValues.put(DBHelper.AUD, aud_9);
                            contentValues.put(DBHelper.PREPOD, prepod_9);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_10);
                            contentValues.put(DBHelper.K_N, k_n_10);
                            contentValues.put(DBHelper.N_P, n_p_10);
                            contentValues.put(DBHelper.AUD, aud_10);
                            contentValues.put(DBHelper.PREPOD, prepod_10);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_11);
                            contentValues.put(DBHelper.K_N, k_n_11);
                            contentValues.put(DBHelper.N_P, n_p_11);
                            contentValues.put(DBHelper.AUD, aud_11);
                            contentValues.put(DBHelper.PREPOD, prepod_11);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_12);
                            contentValues.put(DBHelper.K_N, k_n_12);
                            contentValues.put(DBHelper.N_P, n_p_12);
                            contentValues.put(DBHelper.AUD, aud_12);
                            contentValues.put(DBHelper.PREPOD, prepod_12);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////CHET//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_13);
                            contentValues.put(DBHelper.K_N, k_n_13);
                            contentValues.put(DBHelper.N_P, n_p_13);
                            contentValues.put(DBHelper.AUD, aud_13);
                            contentValues.put(DBHelper.PREPOD, prepod_13);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_14);
                            contentValues.put(DBHelper.K_N, k_n_14);
                            contentValues.put(DBHelper.N_P, n_p_14);
                            contentValues.put(DBHelper.AUD, aud_14);
                            contentValues.put(DBHelper.PREPOD, prepod_14);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_15);
                            contentValues.put(DBHelper.K_N, k_n_15);
                            contentValues.put(DBHelper.N_P, n_p_15);
                            contentValues.put(DBHelper.AUD, aud_15);
                            contentValues.put(DBHelper.PREPOD, prepod_15);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_16);
                            contentValues.put(DBHelper.K_N, k_n_16);
                            contentValues.put(DBHelper.N_P, n_p_16);
                            contentValues.put(DBHelper.AUD, aud_16);
                            contentValues.put(DBHelper.PREPOD, prepod_16);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////PYAT//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_17);
                            contentValues.put(DBHelper.K_N, k_n_17);
                            contentValues.put(DBHelper.N_P, n_p_17);
                            contentValues.put(DBHelper.AUD, aud_17);
                            contentValues.put(DBHelper.PREPOD, prepod_17);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_18);
                            contentValues.put(DBHelper.K_N, k_n_18);
                            contentValues.put(DBHelper.N_P, n_p_18);
                            contentValues.put(DBHelper.AUD, aud_18);
                            contentValues.put(DBHelper.PREPOD, prepod_18);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_19);
                            contentValues.put(DBHelper.K_N, k_n_19);
                            contentValues.put(DBHelper.N_P, n_p_19);
                            contentValues.put(DBHelper.AUD, aud_19);
                            contentValues.put(DBHelper.PREPOD, prepod_19);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_20);
                            contentValues.put(DBHelper.K_N, k_n_20);
                            contentValues.put(DBHelper.N_P, n_p_20);
                            contentValues.put(DBHelper.AUD, aud_20);
                            contentValues.put(DBHelper.PREPOD, prepod_20);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////SUB//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_21);
                            contentValues.put(DBHelper.K_N, k_n_21);
                            contentValues.put(DBHelper.N_P, n_p_21);
                            contentValues.put(DBHelper.AUD, aud_21);
                            contentValues.put(DBHelper.PREPOD, prepod_21);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_22);
                            contentValues.put(DBHelper.K_N, k_n_22);
                            contentValues.put(DBHelper.N_P, n_p_22);
                            contentValues.put(DBHelper.AUD, aud_22);
                            contentValues.put(DBHelper.PREPOD, prepod_22);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_23);
                            contentValues.put(DBHelper.K_N, k_n_23);
                            contentValues.put(DBHelper.N_P, n_p_23);
                            contentValues.put(DBHelper.AUD, aud_23);
                            contentValues.put(DBHelper.PREPOD, prepod_23);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_24);
                            contentValues.put(DBHelper.K_N, k_n_24);
                            contentValues.put(DBHelper.N_P, n_p_24);
                            contentValues.put(DBHelper.AUD, aud_24);
                            contentValues.put(DBHelper.PREPOD, prepod_24);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            //////////////////////////////////VOSKR//////////////////////////////////////////

                            contentValues.put(DBHelper.N_K, n_k_25);
                            contentValues.put(DBHelper.K_N, k_n_25);
                            contentValues.put(DBHelper.N_P, n_p_25);
                            contentValues.put(DBHelper.AUD, aud_25);
                            contentValues.put(DBHelper.PREPOD, prepod_25);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_26);
                            contentValues.put(DBHelper.K_N, k_n_26);
                            contentValues.put(DBHelper.N_P, n_p_26);
                            contentValues.put(DBHelper.AUD, aud_26);
                            contentValues.put(DBHelper.PREPOD, prepod_26);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_27);
                            contentValues.put(DBHelper.K_N, k_n_27);
                            contentValues.put(DBHelper.N_P, n_p_27);
                            contentValues.put(DBHelper.AUD, aud_27);
                            contentValues.put(DBHelper.PREPOD, prepod_27);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            contentValues.put(DBHelper.N_K, n_k_28);
                            contentValues.put(DBHelper.K_N, k_n_28);
                            contentValues.put(DBHelper.N_P, n_p_28);
                            contentValues.put(DBHelper.AUD, aud_28);
                            contentValues.put(DBHelper.PREPOD, prepod_28);
                            database.insert(DBHelper.TABLE_VSE, null, contentValues);

                            ///////////////////////////////////////////////////////////////////////////////////////

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
        RQ.add(request);
    }



}