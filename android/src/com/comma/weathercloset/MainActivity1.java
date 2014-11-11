package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity1 extends Activity implements OnClickListener{

	private Button Btn_signup;
	private Button Btn_posting;
	private Button Btn_timeline;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
 		Btn_signup = (Button) findViewById(R.id.mbtn1);
		Btn_posting = (Button) findViewById(R.id.mbtn2);
		Btn_timeline = (Button) findViewById(R.id.mbtn3);
        Btn_timeline.setOnClickListener(this);
        Btn_signup.setOnClickListener(this);
        Btn_posting.setOnClickListener(this);
        

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

 	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//통신
		switch (v.getId()) {
			case R.id.mbtn1:
				Intent  sintent = new Intent(MainActivity1.this, Signup.class);
				startActivity(sintent);
				break;
			
			case R.id.mbtn2:
				Intent  pintent = new Intent(MainActivity1.this, Posting.class);
				startActivity(pintent);
				break;
			
			case R.id.mbtn3:
				Intent  tintent = new Intent(MainActivity1.this, Timeline.class);
				startActivity(tintent);
				break;
			
			default:
				break;
		}
	}
}
