package com.example.weathercloset;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
public class Notice extends Activity implements OnClickListener{
	ListView list;
	String[] web = {
			"ABC님이 이 글을 좋아합니다.",
			"CD님이 이 글을 좋아합니다.",
			"DE님이 이 글을 좋아합니다.",
			"DEW님이 이 글을 좋아합니다.",
			"DEW님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"WER님이 이 글을 좋아합니다.",
			"ABC님이 이 글을 좋아합니다."
	} ;
	Integer[] imageId = {
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn,
			R.drawable.mypagebtn
	};

	private ImageView mypagebtn;
	private ImageView newpostbtn;
	private ImageView homebtn;
	private ImageView noticebtn;
	private ImageView settingbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notice);

		set_bottombtn();
		set_list();

	}

	private void set_list() {
		CustomList adapter = new
				CustomList(Notice.this, web, imageId);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(Notice.this, " " +web[+ position], Toast.LENGTH_SHORT).show();
			}
		});
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
