package com.javahelps.navigationdrawer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.javahelps.navigationdrawer.R;
import com.javahelps.navigationdrawer.adapters.PossibleIlnessListAdapter;
import com.javahelps.navigationdrawer.database.DBHandler;
import com.javahelps.navigationdrawer.models.Disease;
import com.javahelps.navigationdrawer.models.Illness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsultationActivity2 extends AppCompatActivity {

    ListView possibleIllnessList;
    ArrayList<String> symptoms = new ArrayList<String>();
    List<Disease> illnessList = new ArrayList<Disease>();

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Possible Illness");

        db = new DBHandler(ConsultationActivity2.this);

        symptoms = getIntent().getStringArrayListExtra("symptoms");
        for (int i = 0; i < symptoms.size(); i++) {
            List<Disease> tempList = db.getDiseaseList(symptoms.get(i));

            for (int a = 0; a < tempList.size(); a++) {
                illnessList.add(tempList.get(a));
            }
        }

        List<Disease> noRepeat = new ArrayList<Disease>();

        for (Disease event : illnessList) {
            boolean isFound = false;
            // check if the event name exists in noRepeat
            for (Disease e : noRepeat) {
                if (e.getName().equals(event.getName()))
                    isFound = true;
            }

            if (!isFound) noRepeat.add(event);
        }

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

        possibleIllnessList.setAdapter(new PossibleIlnessListAdapter(ConsultationActivity2.this, noRepeat));

        possibleIllnessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ConsultationActivity2.this, ConsultationActivity3.class);
                intent.putExtra("name", illnessList.get(position).getName());
                intent.putExtra("description", illnessList.get(position).getDescription());
                intent.putExtra("icon", illnessList.get(position).getIcon());
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
