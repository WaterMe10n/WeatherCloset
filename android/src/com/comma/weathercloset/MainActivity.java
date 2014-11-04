package com.comma.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
	String[] items = { "서울", "대전", "대구", "부산" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		ImageView myPageBtn = (ImageView)findViewById(R.id.myPageBtn);
		myPageBtn.setOnClickListener(myPageBtnClick);
		
		//setUpTabs();
		setUpSpinner();
		
	}
	
	ImageView.OnClickListener myPageBtnClick = new ImageView.OnClickListener()
	{
		public void onClick(View v)
		{
			Intent intent = new Intent(MainActivity.this, MyPage.class);
			startActivity(intent);
		}
	};

	private void setUpSpinner() {
		Spinner spin = (Spinner) findViewById(R.id.spinner);
		spin.setOnItemSelectedListener(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spin.setAdapter(adapter);
	}
	/*
	private void setUpTabs() {
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		
		tabHost.addTab(tabHost.newTabSpec("TimeLineTab")
				.setIndicator("TimeLine")
				.setContent(new Intent(this, TimeLineTab.class)));
		
		tabHost.addTab(tabHost.newTabSpec("StatisticsTab")
				.setIndicator("Statistics")
				.setContent(new Intent(this, StatisticsTab.class)));
		
		tabHost.setCurrentTab(0);
	}
	*/
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

	}

	public void onNothingSelected(AdapterView<?> parent) {

	}
	
}
