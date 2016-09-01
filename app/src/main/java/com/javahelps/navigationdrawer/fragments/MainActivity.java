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
        //Micah REMEMBER : ( Illness, Description, Symptoms, Prevention, Medicine )
        db.addDisease(new Disease(1,  "Influenza",               "FLU",      "Fever, Eye Redness",               "prevention 1", "medicine 1", R.drawable.fever1));
        db.addDisease(new Disease(2,  "Sore Eyes",               "EYE",      "Eye Redness",         "prevention 1", "medicine 1", R.drawable.angelo));
        db.addDisease(new Disease(3,  "Common Cold",             "COLD",     "Fever, Eye Redness",               "prevention 1", "medicine 1", R.drawable.cold));
        db.addDisease(new Disease(4,  "Tonsillitis",             "TONSIL",   "Fever",               "prevention 1", "medicine 1", R.drawable.cedric));
        db.addDisease(new Disease(5,  "Asthma",                  "BREATH",   "Cough",               "prevention 1", "medicine 1", R.drawable.asthma));
        db.addDisease(new Disease(6,  "Anemia",                  "BLOOD",    "Fatigue",             "prevention 1", "medicine 1", R.drawable.anemia));
        db.addDisease(new Disease(7,  "Pneumonia",               "BREATH",   "Cough",               "prevention 1", "medicine 1", R.drawable.pneumonia));
        db.addDisease(new Disease(8,  "Tuberculosis",            "BREATH",   "Cough",               "prevention 1", "medicine 1", R.drawable.tubercolosis));
        db.addDisease(new Disease(9,  "Skin Asthma",             "SKIN",     "Skin Complications",  "prevention 1", "medicine 1", R.drawable.skinasthma));
        db.addDisease(new Disease(10, "Constipation",            "BODY",     "Stomach Ache",        "prevention 1", "medicine 1", R.drawable.constipated));
        db.addDisease(new Disease(11, "Heart Burn",              "HEART",    "Chest Complications", "prevention 1", "medicine 1", R.drawable.heartburn));
        db.addDisease(new Disease(12, "Diarrhea",                "STOMACH",  "Fever",               "prevention 1", "medicine 1", R.drawable.diarrhea));
        db.addDisease(new Disease(13, "Stiff Neck",              "NECK",     "Fever",               "prevention 1", "medicine 1", R.drawable.stiffneck));
        db.addDisease(new Disease(14, "Migraine",                "HEAD",     "Headache",            "prevention 1", "medicine 1", R.drawable.headache));
        db.addDisease(new Disease(15, "Gastroenteritis",         "STOMACH",  "Stomach Ache",        "prevention 1", "medicine 1", R.drawable.gastro));
        db.addDisease(new Disease(16, "Hand-Foot-Mouth Disease", "BREATH",   "Sore Throat",         "prevention 1", "medicine 1", R.drawable.headandfoot));
        db.addDisease(new Disease(17, "Dehydration",             "BODY",     "Dizziness",           "prevention 1", "medicine 1", R.drawable.dydrate));
        db.addDisease(new Disease(18, "Dermatitis",              "SKIN",     "Skin Complications",  "prevention 1", "medicine 1", R.drawable.derma));
        db.addDisease(new Disease(19, "Sinusitis",               "BREATH",   "Cough",               "prevention 1", "medicine 1", R.drawable.sinus));
        db.addDisease(new Disease(20, "Ulcer",                   "BODY",     "Vomiting",            "prevention 1", "medicine 1", R.drawable.ulcer));

    }


}

interface OnFragmentInteractionListener {
    void onFragmentInteraction(Uri uri);

}


