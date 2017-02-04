package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Retry extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private TextView retry;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retry);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        retry = (TextView)findViewById(R.id.activity_victory);
        skip = (TextView)findViewById(R.id.activity_victory);
        settingsButton.setOnClickListener(this);
        retry.setOnClickListener(this);
        skip.setOnClickListener(this);
}

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(Retry.this,SettingsActivity.class));
        } /*
        else if(v.getId()==R.id.retry_button){
            startActivity(new Intent(Retry.this,QuestionAsking.class));
        }
        else if(v.getId()==R.id.skip_button){
            startActivity(new Intent(Retry.this,QuestionAsking.class));
        } */
    }
}
