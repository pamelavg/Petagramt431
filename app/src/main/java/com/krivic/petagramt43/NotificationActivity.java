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
import android.widget.Button;

import com.krivic.petagramt43.pojo.Session;
import com.krivic.petagramt43.restApi.EndPointsApi;
import com.krivic.petagramt43.restApi.adapter.RestApiAdapter;
import com.krivic.petagramt43.restApi.model.DataTokenIdRequest;
import com.krivic.petagramt43.restApi.model.UserHerokuResponse;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Button notiButton;

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar   = (Toolbar) findViewById(R.id.toolBar);


        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);


        ActionBar actionBar = getSupportActionBar();



        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

        session = new Session(getApplicationContext());

        notiButton = (Button) findViewById(R.id.notiButton);

        notiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doNotification(v);
            }
        });


    }

    public void doNotification(View v){

        String Token = FirebaseInstanceId.getInstance().getToken();
        sendTheTokenForNotification(Token);

    }

    public void sendTheTokenForNotification(String Token) {
        Log.d("NotificationActivity", "El Token es: " + Token);
        RestApiAdapter restApiAdapter =  new RestApiAdapter();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiHeroku();
        Call<UserHerokuResponse> userHerokuResponseCall = endPointsApi.postRegisterTokenIdUser(new DataTokenIdRequest(session.getUserSeleted(),Token));

        userHerokuResponseCall.enqueue(new Callback<UserHerokuResponse>() {
            @Override
            public void onResponse(Call<UserHerokuResponse> call, Response<UserHerokuResponse> response) {
                UserHerokuResponse userHerokuResponse = response.body();
                Log.d("ID-FIREBASE",userHerokuResponse.getIdDB());
            }

            @Override
            public void onFailure(Call<UserHerokuResponse> call, Throwable t) {

            }
        });

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
                Intent intentContact = new Intent(this,FormActivity.class);
                startActivity(intentContact);
                break;

            case R.id.menu_opt_about:
                Intent intentAbout = new Intent(this,BioActivity.class);
                startActivity(intentAbout);
                break;

            case R.id.menu_opt_config:
                Intent intentConfig = new Intent(this,AccountConfigActivity.class);
                startActivity(intentConfig);
                finish();
                break;

            case R.id.menu_opt_pushNotification:
                Intent intentNoti = new Intent(this,NotificationActivity.class);
                startActivity(intentNoti);
                finish();
                break;

            case R.id.imgBtn_star:
                Intent intentStar = new Intent(this, com.krivic.petagramt43.SecondActivity.class);
                startActivity(intentStar);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
