package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class StartPage2 extends Activity implements OnClickListener{

	private EditText Etext_id, Etext_pw;
	private CheckBox autologin;
	Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpage2);

		Etext_id = (EditText) findViewById(R.id.loginID);
		Etext_pw = (EditText) findViewById(R.id.loginPW);
		autologin = (CheckBox) findViewById(R.id.autologin);
		
		Button loginButton = (Button)findViewById(R.id.loginButton);
		Button signupButton = (Button)findViewById(R.id.signupButton);
		CheckBox autologin = (CheckBox)findViewById(R.id.autologin);
		
		loginButton.setOnClickListener(this);
		signupButton.setOnClickListener(this);
		autologin.setOnClickListener(this);
	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.loginButton:
			String sID = Etext_id.getText().toString();
			String sPW = Etext_pw.getText().toString();

			//서버통신해서 로그인 확인 먼저

			if(autologin.isChecked() == true) {

				SharedPreferences login = getSharedPreferences("login", 0);
				SharedPreferences.Editor editor = login.edit();
				editor.putString("id", sID);
				editor.putString("pw", sPW);
				editor.putBoolean("autologin", true);
				editor.commit();
			}

			Handler mHandler = new Handler();
			mHandler.postDelayed(new Runnable() {
				public void run() { 
					Intent intent = new Intent(StartPage2.this, Timeline.class);
					startActivity(intent);
					overridePendingTransition(R.anim.fade, R.anim.cycle_7);
					finish();
				}
			}, 1300);
			break;
			
		case R.id.signupButton:
			Intent intent = new Intent(StartPage2.this, Signup.class);
			startActivity(intent);
			break;
			
		default:
			break;
		}
	}
}