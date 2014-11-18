package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.content.SharedPreferences;

public class StartPage extends Activity{

	Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpage);

		SharedPreferences login = getSharedPreferences("login", 0);

		if(login.getBoolean("auto", false) == true) {
			Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {
				public void run() { 
					Intent intent = new Intent(StartPage.this, Timeline.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.cycle_7);
					finish();
				}
			}, 1300);
		}
		else {
			Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {
				public void run() { 
					Intent intent = new Intent(StartPage.this, Signup.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.cycle_7);
					finish();
				}
			}, 1300);
		}

	}
}