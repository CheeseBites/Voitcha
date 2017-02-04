package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class AnswerIncorrect extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private RelativeLayout AI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsButton = (ImageView)findViewById(R.id.settings_button);
        AI = (RelativeLayout)findViewById(R.id.activity_answer_incorrect);
        settingsButton.setOnClickListener(this);
        AI.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(AnswerIncorrect.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(AnswerIncorrect.this,QuestionAsking.class));
        }
    }
}
