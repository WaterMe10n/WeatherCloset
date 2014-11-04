package com.comma.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
   
        Button startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Toast.makeText(getApplicationContext(),"Button was touched",
        				Toast.LENGTH_LONG).show();
        	
        		Intent myIntent = new Intent(getApplicationContext(), SignupActivity.class);
        		startActivity(myIntent);
        	}
        	
        });
    }
  
    
}
