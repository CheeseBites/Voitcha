package com.ac.csun.team3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;


import android.widget.AdapterView.OnItemSelectedListener;

import android.widget.AdapterView;

import static com.ac.csun.team3.LaunchActivity.col;
import static com.ac.csun.team3.LaunchActivity.txt;

/**
 * Created by George, 2/4/2017
 * Simple Settings panel, used to handle changing app visuals.
 * At present only effects background colors.
 */

public class SettingsActivity extends Activity implements OnClickListener{
    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private Spinner spinner;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    public void onClick(View v){

        if(v.getId()==R.id.btnSubmit){

            startActivity(new Intent(SettingsActivity.this,LaunchActivity.class));
        }


    }

    public void addListenerOnSpinnerItemSelection(){

        spinner= (Spinner) findViewById(R.id.color_spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton(){

        spinner = (Spinner) findViewById(R.id.color_spinner);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "OnClickListener : " + "\nSpinner : " +
                                String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_LONG).show();
            }
        });

    }


    /**
     * Takes input from Spinner object and selects color for the background of the device
     */
    public class CustomOnItemSelectedListener implements OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

            String colorSelection = parent.getItemAtPosition(pos).toString();
            switch(colorSelection){
                case "White":
                    col=Color.WHITE;
                    txt=Color.BLACK;
                    break;

                case "Pink":
                    col=Color.MAGENTA;
                    txt=Color.BLACK;
                    break;

                case "Blue":
                    col=Color.BLUE;
                    txt=Color.WHITE;
                    break;

                case "Green":
                    col=Color.GREEN;
                    txt=Color.WHITE;
                    break;

                case "Yellow":
                    col=Color.YELLOW;
                    txt=Color.BLACK;
                    break;

                case "Dark Gray":
                    col=Color.DKGRAY;
                    txt=Color.WHITE;
                    break;

            }
            try {
                LinearLayout LS;
                LS = (LinearLayout) findViewById(R.id.activity_settings);
                LS.setBackgroundColor(col);

                Button conf = (Button) findViewById(R.id.btnSubmit);
                conf.setTextColor(txt);
            }
            catch (Exception x){
                Log.e("Error","Color change failed");
            }
            }






        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            //Literally do nothing
        }

    }}


