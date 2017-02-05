package com.ac.csun.team3;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

import static android.R.attr.text;

public class Listening extends Activity {
    private QuestionGenerator randQuestion;
    private static final int MAX_TRIES = 3;
    private TextToSpeech tts;

//    private long startTime = 0L;
//    private long timeInMillis=0L;
//    private long delayTime=8000L;
//    private Handler wait = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        randQuestion = new QuestionGenerator();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);



        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                    // speak("Listening...");

                    speak(randQuestion.question);

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }
        });

        findViewById(R.id.micButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listen();

            }
        });

        findViewById(R.id.replayButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(randQuestion.question);
            }
        });

        findViewById(R.id.skipButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                randQuestion = new QuestionGenerator();
                speak(randQuestion.question);
            }
        });
    }


    private void listen() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");

        try {
            startActivityForResult(i, 100);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(Listening.this, "Your device doesn't support Speech Recognition", Toast.LENGTH_SHORT).show();
        }
    }


    private void speak(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String inSpeech = res.get(0);
                recognition(inSpeech);
            }
        }
    }

    private void recognition(String text) {
        Log.e("Speech", "" + text);
        // counter for number of tries
        int counter = 0;
        // if(text.equals(randQuestion.answer)
        if (text.equals("4") || text.equals("four")) {
            Log.i("Feedback", "That is correct!");
        } else {
            Log.i("Feedback", "incorrect!");
            counter++;
            if (counter == MAX_TRIES) {
                Log.i("Feedback", "Max tries reached.");
            }
        }
    }

        @Override
        public void onDestroy () {
            if (tts != null) {
                tts.stop();
                tts.shutdown();
            }
            super.onDestroy();
        }
/*
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
*/

    }

