package com.javahelps.navigationdrawer.fragments;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.javahelps.navigationdrawer.R;
import com.javahelps.navigationdrawer.database.DBHandler;
import com.javahelps.navigationdrawer.models.Disease;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {


    SharedPreferences prefs = null;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Ask D' Doctor");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prefs = getSharedPreferences("com.javahelps.navigationdrawer", MODE_PRIVATE);

        //if first time run, insert diseases to database
        if (prefs.getBoolean("firstrun", true)) {
            insertDiseasesToDB();
            prefs.edit().putBoolean("firstrun", false).commit();
        }


        // Set the home as default
        Fragment fragment = new ConsultationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Create a new fragment and specify the planet to show based on position
        Fragment fragment;

        if (id == R.id.nav_consultation) {
            // Handle the settings action
            fragment = new ConsultationFragment();
        } else if (id == R.id.nav_first) {
            fragment = new FirstFragment();
        } else if (id == R.id.nav_help) {
            fragment = new HelpFragment();
        } else if (id == R.id.nav_aboutus) {
            fragment = new AboutFragment();
        } else {
            // Anything else is home
            fragment = new ConsultationFragment();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void insertDiseasesToDB() {
        DBHandler db = new DBHandler(MainActivity.this);
        db.addDisease(new Disease(1, "sakit 1", "desc 1", "symptoms 1", "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(2, "sakit 2", "desc 2", "symptoms 2", "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(3, "sakit 3", "desc 3", "symptoms 3", "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(4, "sakit 4", "desc 4", "symptoms 4", "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(5, "sakit 5", "desc 5", "symptoms 1", "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(6, "sakit 6", "desc 6", "sipon", "prevention 1", "medicine 1", R.drawable.angelo));
    }


}

interface OnFragmentInteractionListener {
    void onFragmentInteraction(Uri uri);

}


