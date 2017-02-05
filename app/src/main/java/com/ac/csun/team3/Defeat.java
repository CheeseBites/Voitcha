package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Defeat extends Activity implements View.OnClickListener{
    private RelativeLayout defeated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defeat);
        defeated = (RelativeLayout)findViewById(R.id.activity_defeat);
        defeated.setOnClickListener(this);
    }

    public void onClick(View v) {
            startActivity(new Intent(Defeat.this,LaunchActivity.class));
    }
}

