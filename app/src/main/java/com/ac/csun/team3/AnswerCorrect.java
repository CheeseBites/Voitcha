package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class AnswerCorrect extends Activity implements View.OnClickListener{
    private ImageView settingsButton;
    private RelativeLayout AC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_correct);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        AC = (RelativeLayout)findViewById(R.id.activity_answer_correct);
        settingsButton.setOnClickListener(this);
        AC.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(AnswerCorrect.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(AnswerCorrect.this,Victory.class));
        }
    }
}
