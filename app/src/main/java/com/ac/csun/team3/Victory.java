package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
// end screen for correct answer
public class Victory extends Activity implements View.OnClickListener{
    private RelativeLayout Victory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        Victory = (RelativeLayout)findViewById(R.id.activity_victory);
        Victory.setOnClickListener(this);
    }

    public void onClick(View v) {
            startActivity(new Intent(Victory.this,LaunchActivity.class));
    }
}
