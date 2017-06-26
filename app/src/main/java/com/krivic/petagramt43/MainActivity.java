package com.krivic.petagramt43;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.krivic.petagramt43.adapter.PageAdapter;
import com.krivic.petagramt43.fragment.InfoMascotaFragment;
import com.krivic.petagramt43.fragment.ReciclerViewFragment;
import com.krivic.petagramt43.pojo.Session;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    Session session;

    ImageButton imgBtn_star;
    ImageView   img_bone_yellow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(getApplicationContext());
        String idUser = session.getUserSeleted();

        if(idUser == null){
            session.setUserSeleted("5451658654");
        }


        toolbar   = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();



        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);


        ActionBar actionBar = getSupportActionBar();


        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }



    private ArrayList<Fragment> addFragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReciclerViewFragment());
        fragments.add(new InfoMascotaFragment());

        return  fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icon_notification);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_tab_one);
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
                Intent intentConfig = new Intent(this, com.krivic.petagramt43.AccountConfigActivity.class);
                startActivity(intentConfig);
                finish();
                break;

            case R.id.menu_opt_pushNotification:
                Intent intentNoti = new Intent(this, com.krivic.petagramt43.NotificationActivity.class);
                startActivity(intentNoti);
                finish();
                break;

            case R.id.imgBtn_star:

                Intent intentStar = new Intent(MainActivity.this, com.krivic.petagramt43.SecondActivity.class);
                startActivity(intentStar);
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}
