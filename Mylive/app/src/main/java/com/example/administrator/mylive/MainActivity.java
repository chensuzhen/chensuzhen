package com.example.administrator.mylive;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ListView mLeftmenu;
    private ActionBarDrawerToggle mDrawerToggle;
    //private ArrayAdapter arrayAdapter;
    //private String[] mPlanetTitles;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar= (Toolbar) findViewById(R.id.mtoolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        mLeftmenu = (ListView) findViewById(R.id.lv_left_menu);


        //mLeftmenu.setAdapter(new ArrayAdapter(this, R.layout.activity_main, mPlanetTitles));
        //arrayAdapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1,mPlanetTitles);
        //mLeftmenu.setAdapter(arrayAdapter);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }




}
