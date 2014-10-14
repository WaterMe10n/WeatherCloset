package com.comma.weathercloset;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
	String[] items = { "서울", "대전", "대구", "부산" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setUpSpinner();
		setUpTabs();
	}

	private void setUpSpinner() {
		Spinner spin = (Spinner) findViewById(R.id.spinner);
		spin.setOnItemSelectedListener(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spin.setAdapter(adapter);
	}
	
	private void setUpTabs() {
		TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		
		TabSpec spec1 = tabHost.newTabSpec("timelineTab").setContent(R.id.timelineTab).
				setIndicator(getString(R.string.timelineTab));
		tabHost.addTab(spec1);
		
		TabSpec spec2 = tabHost.newTabSpec("statisticsTab").setContent(R.id.statisticsTab).
				setIndicator(getString(R.string.statisticsTab));
		tabHost.addTab(spec1);
		
		tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 80;
		tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 80;
		
		RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams
				(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		
		RelativeLayout rl1 = (RelativeLayout) tabHost.getTabWidget().getChildAt(0);
		rl1.setGravity(Gravity.CENTER_VERTICAL);
		TextView tv1 = (TextView) rl1.getChildAt(0);
		tv1.setLayoutParams(tvParams);
		tv1.setTextAppearance(this, android.R.style.TextAppearance_Medium);
		tv1.setPadding(10, 0, 10, 0);
		tv1.setGravity(Gravity.CENTER);
		
		RelativeLayout rl2 = (RelativeLayout) tabHost.getTabWidget().getChildAt(1);
		rl2.setGravity(Gravity.CENTER_VERTICAL);
		TextView tv2 = (TextView) rl2.getChildAt(1);
		tv2.setLayoutParams(tvParams);
		tv2.setTextAppearance(this, android.R.style.TextAppearance_Medium);
		tv2.setPadding(10, 0, 10, 0);
		tv2.setGravity(Gravity.CENTER);
	}
	
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

	}

	public void onNothingSelected(AdapterView<?> parent) {

	}
	
}
