package com.example.timetable;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Infromation extends AppCompatActivity {

    String phone_number;
    TextView tv_1_1;
    TextView tv_1_2;
    TextView tv_1_3;
    Switch switch_settings;
    SharedPreferences sPref;
    RequestQueue JJ;
    private static final int PERMISSIONS_REQUEST_PHONE_CALL = 100;
    private static String[] PERMISSIONS_PHONECALL = {Manifest.permission.CALL_PHONE};



    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.information);

        tv_1_1 = (TextView) findViewById(R.id.tv_1);
        tv_1_2 = (TextView) findViewById(R.id.tv_2);
        tv_1_3 = (TextView) findViewById(R.id.tv_3);

        JJ = Volley.newRequestQueue(this);
        jsonParse();
        /////////////////////////////////////////////////////////////////////////////////////
        switch_settings = findViewById(R.id.switch_inversiya);
        sPref = getSharedPreferences("inversiya", MODE_PRIVATE);
        boolean inversiya = sPref.getBoolean("", false);


        ////////////////////////////////////////////////////////////
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_settings:
                                Intent intent_settings = new Intent(Infromation.this, Settings.class);
                                startActivity(intent_settings);
                                break;
                            case R.id.action_home:
                                Intent intent_home = new Intent(Infromation.this, MainActivity.class);
                                startActivity(intent_home);
                                break;
                        }
                        return false;
                    }
                });
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        ////////////////////////////////////////////////////////////

    }




    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Infromation.this, MainActivity.class);
        startActivity(intent);
    }

    String url = "http://isitrasp.beget.tech/files/PHPbyAPP/information.php";

    private void jsonParse(){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray INF = response.getJSONArray("zagalovok");
                            for (int i=0; i<INF.length(); i++){
                                JSONObject pars = INF.getJSONObject(i);

                                String name = pars.getString("name");
                                final String phone = pars.getString("phone");
                                String data = pars.getString("data");
                                tv_1_1.append(name + '\n');
                                tv_1_2.append(phone + '\n');
                                tv_1_3.append(data + '\n' );


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
        JJ.add(request);


    }

}
