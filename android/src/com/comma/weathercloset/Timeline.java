package com.example.weathercloset;

import java.util.Random;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

public class Timeline extends Activity {

	private Spinner Spinner_City;
//	private TextView rating;
	ListView list;
	String[] web = {
		"Google Plus",
		"Twitter",
		"Windows"
	} ;
	Integer[] imageId = {
		R.drawable.squareimg,
		R.drawable.squareimg,
		R.drawable.squareimg
	};
	float values[] = { 300, 300, 300, 300,300 };


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);
		
		Spinner_City =(Spinner)findViewById(R.id.s_city);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(
        		this, R.array.city, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_City.setAdapter(adapter1);
//        rating=(TextView) findViewById(R.id.tabtxt2);
        
        
		TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
     
        TabHost.TabSpec spec = tabHost.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("타임라인");          
        tabHost.addTab(spec);
        
        spec = tabHost.newTabSpec("tag2");
        spec.setContent(R.id.Ltab2);
        spec.setIndicator("통계");          
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);       
 
        CustomList adapter = new CustomList(Timeline.this, web, imageId);
        list=(ListView)findViewById(R.id.tab1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	@Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(Timeline.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
           }
        });

        LinearLayout lv1 = (LinearLayout) findViewById(R.id.piechart);
        values = calculateData(values);
        MyGraphview graphview = new MyGraphview(this, values);
        lv1.addView(graphview);
	}

	private float[] calculateData(float[] data) {
		float total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = 360 * (data[i] / total);
		}
		return data;
	}

	public class MyGraphview extends View {
		private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		private float[] value_degree;
		RectF rectf = new RectF(120, 120, 380, 380);
		float temp = 0;
		
		public MyGraphview(Context context, float[] values) {
			super(context);
			value_degree = new float[values.length];
			for (int i = 0; i < values.length; i++) {
				value_degree[i] = values[i];
			}
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			Random r;
			for (int i = 0; i < value_degree.length; i++) {
				if (i == 0) {
					r = new Random();
					int color = Color.argb(100, r.nextInt(256), r.nextInt(256),
					r.nextInt(256));
					paint.setColor(color);
					canvas.drawArc(rectf, 0, value_degree[i], true, paint);
				} else {
					temp += value_degree[i - 1];
					r = new Random();
					int color = Color.argb(255, r.nextInt(256), r.nextInt(256),
					r.nextInt(256));
					paint.setColor(color);
					canvas.drawArc(rectf, temp, value_degree[i], true, paint);
				}
			}
		}  
	}

}