package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class QuestionStartScreen extends Activity implements View.OnClickListener {
    private ImageView settingsButton;
    private RelativeLayout QS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_start);

        settingsButton = (ImageView)findViewById(R.id.settings_button);
        QS = (RelativeLayout)findViewById(R.id.activity_question_start);
        settingsButton.setOnClickListener(this);
        QS.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId()==R.id.settings_button){
            startActivity(new Intent(QuestionStartScreen.this,SettingsActivity.class));
        }
        else{
            startActivity(new Intent(QuestionStartScreen.this,QuestionAsking.class));
        }
    }
}
