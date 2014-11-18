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

		
		// 자동로그인 해제 
		SharedPreferences login = getSharedPreferences("login", 0);
		SharedPreferences.Editor editor = login.edit();
		editor.putBoolean("autologin", false);
		editor.commit();
		//
		
		//자동로그인 설정되있으면 로그인 후 타임라인으로
		if(login.getBoolean("autologin", false) == true) {
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
		//자동로그인 설정되어있지 않으면 로그인, 회원가입하는 곳으로
		else {
			Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {
				public void run() { 
					Intent intent = new Intent(StartPage.this, StartPage2.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.hold);
					finish();
				}
			}, 1300);
		}

	}
}