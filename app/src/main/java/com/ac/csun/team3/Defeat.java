package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Ian / Victoria, 2/4/2017
 * If the user enters [default=3] incorrect answers, they are condemned to their fate on this screen
 * (However, the full screen is also a button that links back to the launch page)
 * In an actual implementation, this would have an additional delay timer as a penalty
 */

public class Defeat extends Activity implements View.OnClickListener{
    private RelativeLayout defeated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defeat);
        defeated = (RelativeLayout)findViewById(R.id.activity_defeat);
        defeated.setOnClickListener(this);
    }

    //Return to Launch. Replace with penalty timer.
    public void onClick(View v) {
        startActivity(new Intent(Defeat.this,LaunchActivity.class));
    }
}

