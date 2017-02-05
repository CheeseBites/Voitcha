package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Defeat extends Activity implements View.OnClickListener{
    private ImageView settingsButton;
    private RelativeLayout defeated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        settingsButton = (ImageView)findViewById(R.id.settings_button);
        defeated = (RelativeLayout)findViewById(R.id.activity_defeat);
        settingsButton.setOnClickListener(this);
        defeated.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(Defeat.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(Defeat.this,LaunchActivity.class));
        }
    }
}

