package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class Listening extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private long startTime = 0L;
    private long timeInMillis=0L;
    private long delayTime=8000L;
    private Handler wait = new Handler();


    private TextToSpeech tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "This Language is not supported");
                }
                speak("Listening");

            } else {
                Log.e("TTS", "Initilization Failed!");
            }
        }
    });

    private void speak(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }else{
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        settingsButton = (ImageView)findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this);
        startTime= SystemClock.uptimeMillis();
        wait.postDelayed(waitTime,0);
    }

    //Ian: Settings button, wait timer on answer, CheckAnswer (need to fix that logic)
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
    private void checkAnswer(){ //TODO: FIX
        boolean correct=true;
        if(correct) startActivity(new Intent(Listening.this,AnswerCorrect.class));
        else startActivity(new Intent(Listening.this,AnswerIncorrect.class));
    }
}
