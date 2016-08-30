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
import com.javahelps.navigationdrawer.adapters.CustomListAdapter;
import com.javahelps.navigationdrawer.adapters.SelectedSymptomsListAdapter;
import com.javahelps.navigationdrawer.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class ConsultationActivity1 extends AppCompatActivity {


    Button button2;

    private ListView selectedList;
    private ListView symptomsListView;

    private CustomListAdapter symptomsListAdapter;
    private SelectedSymptomsListAdapter selectedSymptomsListAdapter;

    private List<String> selectedSymptoms = new ArrayList<String>();
    private int symptomsCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Symptoms");

        addListenerOnButton();
    }


    public void addListenerOnButton() {
        final Context context = this;

        button2 = (Button) findViewById(R.id.Proceed);

        selectedList = (ListView) findViewById(R.id.selectedList);
        symptomsListView = (ListView) findViewById(R.id.selectionList);

        List<String> symptomsList = new ArrayList<String>();
        symptomsList.add("one");
        symptomsList.add("two");
        symptomsList.add("three");
        symptomsList.add("four");
        symptomsList.add("five");
        symptomsList.add("six");
        symptomsList.add("one");
        symptomsList.add("two");
        symptomsList.add("three");
        symptomsList.add("four");
        symptomsList.add("five");
        symptomsList.add("six");
        symptomsList.add("one");
        symptomsList.add("two");
        symptomsList.add("three");
        symptomsList.add("four");
        symptomsList.add("five");
        symptomsList.add("six");
        symptomsList.add("one");
        symptomsList.add("two");
        symptomsList.add("three");
        symptomsList.add("four");
        symptomsList.add("five");
        symptomsList.add("six");
        symptomsList.add("one");
        symptomsList.add("two");
        symptomsList.add("three");
        symptomsList.add("four");
        symptomsList.add("five");
        symptomsList.add("six");

        symptomsListAdapter = new CustomListAdapter(ConsultationActivity1.this, symptomsList);


        symptomsListView.setAdapter(symptomsListAdapter);
        symptomsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                symptomsCounter = symptomsCounter + 1;

                if (symptomsCounter <= 3) {
                    selectedSymptoms.add(symptomsListAdapter.getItem(position).toString());
                    selectedSymptomsListAdapter = new SelectedSymptomsListAdapter(ConsultationActivity1.this, selectedSymptoms);
                    selectedList.setAdapter(selectedSymptomsListAdapter);
                } else {
                    Helper.showErrorDialog(context, getString(R.string.error_symptoms_number), getString(R.string.label_ok));
                }

                if (symptomsCounter > 3) {
                    symptomsCounter = 3;
                }

            }
        });

        selectedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                symptomsCounter = symptomsCounter - 1;

                selectedSymptoms.remove(position);
                selectedSymptomsListAdapter = new SelectedSymptomsListAdapter(ConsultationActivity1.this, selectedSymptoms);
                selectedList.setAdapter(selectedSymptomsListAdapter);

                if (symptomsCounter < 0) {
                    symptomsCounter = 0;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultationActivity1.this, ConsultationActivity2.class);
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