package com.ac.csun.team3;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.LinearLayout;


import android.widget.AdapterView.OnItemSelectedListener;

import android.widget.AdapterView;






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
                Toast.makeText(SettingsActivity.this,
                        "OnClickListener : " + "\nSpinner : " + String.valueOf(spinner.getSelectedItem()),
                        Toast.LENGTH_LONG).show();
            }
        });

    }








    public class CustomOnItemSelectedListener implements OnItemSelectedListener {
        LinearLayout l1 = (LinearLayout)findViewById(R.id.activity_settings);
        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
//            Toast.makeText(parent.getContext(),
//                      parent.getItemAtPosition(pos).toString(),
//                    Toast.LENGTH_LONG).show();
            String colorSelection = parent.getItemAtPosition(pos).toString();
            switch(colorSelection){
                case "White":
                    l1.setBackgroundColor(Color.WHITE);
                    break;

                case "Red":
                    l1.setBackgroundColor(Color.MAGENTA);
                    break;

                case "Blue":
                    l1.setBackgroundColor(Color.BLUE);
                    break;

                case "Green":
                    l1.setBackgroundColor(Color.GREEN);
                    break;

                case "Purple":
                    l1.setBackgroundColor(Color.YELLOW);
                    break;

            }
            }






        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            //Literally do nothing
        }

    }}


