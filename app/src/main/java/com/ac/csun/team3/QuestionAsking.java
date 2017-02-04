package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
}
