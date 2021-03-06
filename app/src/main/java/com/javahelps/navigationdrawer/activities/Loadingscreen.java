package com.javahelps.navigationdrawer.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.javahelps.navigationdrawer.R;
import com.javahelps.navigationdrawer.fragments.MainActivity;

public class Loadingscreen extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 4000;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loadingscreen);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Loadingscreen.this, MainActivity.class);
                Loadingscreen.this.startActivity(mainIntent);
                Loadingscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
