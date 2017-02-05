package com.ac.csun.team3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    public static int col=-32767;
    public static int txt=-32767;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        if (col==-32767) col=Color.WHITE;
        if (txt==-32767) txt=Color.BLACK;


        RelativeLayout LA = (RelativeLayout) findViewById(R.id.activity_launch);
        LA.setBackgroundColor(col);
        TextView intro = (TextView) findViewById(R.id.textView);
        intro.setTextColor(txt);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);
        LA.setOnClickListener(this);
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
