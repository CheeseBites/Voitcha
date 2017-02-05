package com.ac.csun.team3;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LaunchActivity extends Activity implements OnClickListener {
    private ImageView settingsButton;
    private RelativeLayout launch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        launch = (RelativeLayout)findViewById(R.id.activity_launch);
        settingsButton.setOnClickListener(this);
        launch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { //The full screen is a button handler, used to advance.
        //However, the Settings gear button links to the Settings panel in stead.
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(LaunchActivity.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(LaunchActivity.this,Listening.class));
        }
    }

}
