package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
/**
 * Created by Ian / Victoria, 2/4/2017
 * If the user enters a correct answer, they are sent here.
 * They may or may not also be informed that they are "dank".
 * In an actual implementation, this would become a return link to the calling source page.
 * This page is also a button that returns to the launch page.
 */
public class Victory extends Activity implements View.OnClickListener{
    private RelativeLayout Victory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        Victory = (RelativeLayout)findViewById(R.id.activity_victory);
        Victory.setOnClickListener(this);
    }

    //Return to Launch. Replace this with "return to wherever you came from"
    public void onClick(View v) {
        startActivity(new Intent(Victory.this,LaunchActivity.class));
    }
}
