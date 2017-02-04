package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

public class Listening extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private long startTime = 0L;
    private long timeInMillis=0L;
    private long delayTime=8000L;
    private Handler wait = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        settingsButton = (ImageView)findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);
        startTime= SystemClock.uptimeMillis();
        wait.postDelayed(waitTime,0);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(Listening.this,SettingsActivity.class));
        }
    }

    private Runnable waitTime = new Runnable(){
        public void run(){
            timeInMillis=SystemClock.uptimeMillis();
            if(timeInMillis-startTime>=delayTime){
                checkAnswer();
            }
            else{
                wait.postDelayed(this, 0);
            }
        }
    };
    private void checkAnswer(){
        boolean correct=true;
        if(correct) startActivity(new Intent(Listening.this,AnswerCorrect.class));
        else startActivity(new Intent(Listening.this,AnswerIncorrect.class));
    }
}
