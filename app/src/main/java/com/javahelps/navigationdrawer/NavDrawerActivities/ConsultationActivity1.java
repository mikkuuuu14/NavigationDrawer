package com.javahelps.navigationdrawer.NavDrawerActivities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.javahelps.navigationdrawer.R;

public class ConsultationActivity1 extends AppCompatActivity {


    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation1);
        addListenerOnButton();
    }


    public void addListenerOnButton() {
        final Context context = this;

        button2 = (Button) findViewById(R.id.button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultationActivity1.this, ConsultationActivity2.class);
            }

        });
    }
}
