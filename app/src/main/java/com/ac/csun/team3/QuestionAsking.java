package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Locale;

public class QuestionAsking extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private RelativeLayout QA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_asking);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        QA = (RelativeLayout)findViewById(R.id.activity_question_asking);
        settingsButton.setOnClickListener(this);
        QA.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(QuestionAsking.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(QuestionAsking.this,Listening.class));
        }
    }



    private TextToSpeech tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "This Language is not supported");
                }
                speak("Question");

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
}
