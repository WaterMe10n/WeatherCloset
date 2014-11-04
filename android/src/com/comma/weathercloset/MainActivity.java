package com.comma.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        

        Button gologBtn = (Button)findViewById(R.id.gologBtn);
        gologBtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Toast.makeText(getApplicationContext(),"Button was touched",
        				Toast.LENGTH_LONG).show();
        	
        		Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
        		startActivity(myIntent);
        	}
        	
        });
    }
        	
      
    
  
    
}
