package com.javahelps.navigationdrawer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.javahelps.navigationdrawer.R;
import com.javahelps.navigationdrawer.adapters.PossibleIlnessListAdapter;
import com.javahelps.navigationdrawer.models.Illness;

import java.util.ArrayList;
import java.util.List;

public class ConsultationActivity2 extends AppCompatActivity {

    ListView possibleIllnessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Possible Illness");

        possibleIllnessList = (ListView) findViewById(R.id.possibleIllnessList);

        List<Illness> list = new ArrayList<Illness>();
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.cold));
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.cold));
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.flu));
        list.add(new Illness("one", "two", R.drawable.flu));

        possibleIllnessList.setAdapter(new PossibleIlnessListAdapter(ConsultationActivity2.this, list));

        possibleIllnessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ConsultationActivity2.this, ConsultationActivity3.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
