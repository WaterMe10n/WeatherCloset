package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Setting extends Activity  implements OnClickListener{

	private ImageView mypagebtn;
	private ImageView newpostbtn;
	private ImageView homebtn;
	private ImageView noticebtn;
	private ImageView settingbtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		set_bottombtn();
	}

	private void set_bottombtn() {
		mypagebtn = (ImageView) findViewById(R.id.myPageBtn);
		newpostbtn = (ImageView) findViewById(R.id.newPostBtn);
		homebtn = (ImageView) findViewById(R.id.homeBtn);
		noticebtn = (ImageView) findViewById(R.id.noticeBtn);
		settingbtn = (ImageView) findViewById(R.id.settingBtn);

		mypagebtn.setOnClickListener(this);
		newpostbtn.setOnClickListener(this);
		homebtn.setOnClickListener(this);
		noticebtn.setOnClickListener(this);
		settingbtn.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		//통신
		switch (v.getId()) {
		case R.id.myPageBtn:
			Intent  mintent = new Intent(this, MyPage.class);
			mintent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(mintent);
			overridePendingTransition(R.anim.hold, R.anim.cycle_7);
			break;

		case R.id.newPostBtn:
			Intent  pintent = new Intent(this, Posting.class);
			pintent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(pintent);
			overridePendingTransition(R.anim.hold, R.anim.cycle_7);
			break;

		case R.id.homeBtn:
			Intent  hintent = new Intent(this, Timeline.class);
			hintent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(hintent);
			overridePendingTransition(R.anim.hold, R.anim.cycle_7);
			break;

		case R.id.noticeBtn:
			Intent  nintent = new Intent(this, Notice.class);
			nintent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(nintent);
			overridePendingTransition(R.anim.hold, R.anim.cycle_7);
			break;
			
		case R.id.settingBtn:
			Intent  sintent = new Intent(this, Setting.class);
			sintent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(sintent);
			overridePendingTransition(R.anim.hold, R.anim.cycle_7);
			break;
		default:
			break;
		}
	}

}