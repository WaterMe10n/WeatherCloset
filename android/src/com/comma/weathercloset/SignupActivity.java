package com.comma.weathercloset;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.Toast;

public class SignupActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       
        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Toast.makeText(getApplicationContext(),"getback",
        				Toast.LENGTH_LONG).show();
        			finish();
        	}
        	
        });
    }
  
    
}
