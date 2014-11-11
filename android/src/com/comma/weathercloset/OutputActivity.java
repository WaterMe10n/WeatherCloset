package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OutputActivity extends Activity {
	
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);
        textview1 = (TextView) findViewById(R.id.textView1);
        textview2 = (TextView) findViewById(R.id.textView2);
        textview3 = (TextView) findViewById(R.id.textView3);
        textview4 = (TextView) findViewById(R.id.textView4);
        textview5 = (TextView) findViewById(R.id.textView5);
        textview6 = (TextView) findViewById(R.id.textView6);
        textview7 = (TextView) findViewById(R.id.textView7);
        textview8 = (TextView) findViewById(R.id.textView8);
        Intent intent = getIntent();
		String status = intent.getStringExtra("Status");
		String explain = intent.getStringExtra("Explain");
		String city = intent.getStringExtra("City");
		String outer = intent.getStringExtra("outer");
		String top = intent.getStringExtra("top");
		String onepiece = intent.getStringExtra("onepiece");
		String bottoms = intent.getStringExtra("bottoms");
		String acc = intent.getStringExtra("acc");
		
		textview1.setText("체감 "+status);
		textview2.setText("설명 "+explain);
		textview3.setText("도시 "+city);
		textview4.setText(outer);
		textview5.setText(top);
		textview6.setText(bottoms);
		textview7.setText(onepiece);
		textview8.setText(acc);
		Log.i("MyTag","444 >> ");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.output, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
