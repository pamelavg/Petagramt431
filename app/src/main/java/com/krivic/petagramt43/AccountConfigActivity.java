package com.krivic.petagramt43;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.krivic.petagramt43.pojo.Session;

public class AccountConfigActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    private Toolbar toolbar;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_config);

        toolbar   = (Toolbar) findViewById(R.id.toolBar);

        session = new Session(getApplicationContext());

        //actionbar
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);


        ActionBar actionBar = getSupportActionBar();



        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }



        spinner = (Spinner) findViewById(R.id.theSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.users_array, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_opt_contact:
                Intent intentContact = new Intent(this, com.krivic.petagramt43.FormActivity.class);
                startActivity(intentContact);
                break;

            case R.id.menu_opt_about:
                Intent intentAbout = new Intent(this, com.krivic.petagramt43.BioActivity.class);
                startActivity(intentAbout);
                break;

            case R.id.menu_opt_config:
                Intent intentConfig = new Intent(this,AccountConfigActivity.class);
                startActivity(intentConfig);
                break;

            case R.id.menu_opt_pushNotification:
                Intent intentNoti = new Intent(this, com.krivic.petagramt43.NotificationActivity.class);
                startActivity(intentNoti);

                break;

            case R.id.imgBtn_star:
                //Log.d("STATE","Se hace clic en img estrella");
                Intent intentStar = new Intent(this, com.krivic.petagramt43.SecondActivity.class);
                startActivity(intentStar);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position){

            case 0:
                session.setUserSeleted("5451658654");
            break;
            case 1:
                session.setUserSeleted("5431565715");
            break;
            case 2:
                session.setUserSeleted("5560454415");
            break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.e("AccountConfigActi","Nada seleccionado");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AccountConfigActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
