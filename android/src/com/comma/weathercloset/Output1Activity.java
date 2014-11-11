package com.example.weathercloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Output1Activity extends Activity {
	
	private TextView stv1;
	private TextView stv2;
	private TextView stv3;
	private TextView stv4;
	private TextView stv5;
	private TextView stv6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output1);
		
        stv1 = (TextView) findViewById(R.id.stv1);
        stv2 = (TextView) findViewById(R.id.stv2);
        stv3 = (TextView) findViewById(R.id.stv3);
        stv4 = (TextView) findViewById(R.id.stv4);
        stv5 = (TextView) findViewById(R.id.stv5);
        stv6 = (TextView) findViewById(R.id.stv6);
        Intent intent = getIntent();
        
		String msg_id = intent.getStringExtra("ID");
		String msg_nck = intent.getStringExtra("NICKNAME");
		String msg_pw = intent.getStringExtra("PASSWORD");
		String msg_cpw = intent.getStringExtra("CONFIRM PW");
		String msg_age = intent.getStringExtra("AGE");
		String msg_sex = intent.getStringExtra("SEX");
		
		stv1.setText(msg_id);
		stv2.setText(msg_nck);
		stv3.setText(msg_pw);
		stv4.setText(msg_cpw);
		stv5.setText(msg_age);
		stv6.setText(msg_sex);
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
