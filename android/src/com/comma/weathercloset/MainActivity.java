package com.comma.weathercloset;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


public class MainActivity extends FragmentActivity implements AdapterView.OnItemSelectedListener {
	
	int mCurrentFragmentIndex;
	public final static int FRAGMENT_ONE = 0;
	public final static int FRAGMENT_TWO = 1;
	
	String[] items = { "서울", "대전", "대구", "부산" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button timelineFragment = (Button) findViewById(R.id.timelineFragment);
		timelineFragment.setOnClickListener((OnClickListener) this);
		Button statisticsFragment = (Button) findViewById(R.id.statisticsFragment);
		statisticsFragment.setOnClickListener((OnClickListener) this);
		
		mCurrentFragmentIndex = FRAGMENT_ONE;
		fragmentReplace(mCurrentFragmentIndex);
		
		ImageView myPageBtn = (ImageView)findViewById(R.id.myPageBtn);
		myPageBtn.setOnClickListener(myPageBtnClick);
		
		//setUpTabs();
		setUpSpinner();
		
	}
	
	public void fragmentReplace(int reqNewFragmentIndex) {

		Fragment newFragment = null;

		Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();

		transaction.replace(R.id.main_fragment, newFragment);

		// Commit the transaction
		transaction.commit();

	}

	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case FRAGMENT_ONE:
			newFragment = new OneFragment();
			break;
		case FRAGMENT_TWO:
			newFragment = new TwoFragment();
			break;
			
		default:
			Log.d(TAG, "Unhandle case");
			break;
		}

		return newFragment;
	}

	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.timelineFragment:
			mCurrentFragmentIndex = FRAGMENT_ONE;
			fragmentReplace(mCurrentFragmentIndex);
			break;
		case R.id.statisticsFragment:
			mCurrentFragmentIndex = FRAGMENT_TWO;
			fragmentReplace(mCurrentFragmentIndex);
			break;
		}

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
