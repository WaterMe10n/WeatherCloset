/*package com.comma.weathercloset;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
	String[] items = { "서울", "대전", "대구", "부산" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

       
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        		this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        
        spin.setAdapter(adapter);
	}

	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		
	}

	public void onNothingSelected(AdapterView<?> parent) {
		
	}

}*/
