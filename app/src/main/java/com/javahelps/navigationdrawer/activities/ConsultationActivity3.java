package com.javahelps.navigationdrawer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.javahelps.navigationdrawer.R;

public class ConsultationActivity3 extends AppCompatActivity {

    String name, desc;
    int icon;

    TextView nameText, descText;
    ImageView iconImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Illness Description");

        Bundle data = getIntent().getExtras();
        name = data.getString("name");
        desc = data.getString("description");
        icon = data.getInt("icon");

        nameText = (TextView) findViewById(R.id.name);
        descText= (TextView) findViewById(R.id.description);
        iconImage = (ImageView) findViewById(R.id.icon);

        nameText.setText(name);
        descText.setText(desc);
        iconImage.setImageResource(icon);

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
