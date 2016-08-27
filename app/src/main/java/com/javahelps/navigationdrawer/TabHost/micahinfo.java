package com.javahelps.navigationdrawer.TabHost;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.javahelps.navigationdrawer.R;

/**
 * Created by Cedric on 8/14/2016.
 */
public class micahinfo extends Activity {

//
//    }Button button;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Get the view from activity_main.xml
//        setContentView(R.layout.activity_main);
//
//        // Locate the button in activity_main.xml
//        button = (Button) findViewById(R.id.mikko);
//
//        // Capture button clicks
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View arg0) {
//
//                // Start NewActivity.class
//                Intent myIntent = new Intent(micahinfo.this,
//                        MainActivity.class);
//                startActivity(myIntent);
//            }
//        });
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.micahinfo);
    }

}

