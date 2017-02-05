package com.ac.csun.team3;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/**
 * Created by Ian on 2/3/2017.
 * Launch page, app launches to here. Contains generic warning 'make sure audio is on'
 * Also contains link to Settings panel for various visual options
 * The entire screen apart from the settings gear is a button that advances to the actual
 * "capcha replacement" system.
 */

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

    //Press Gear to go to Settings panel. Press anywhere else to advance to the main app.
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(LaunchActivity.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(LaunchActivity.this,Listening.class));
        }
    }

}
